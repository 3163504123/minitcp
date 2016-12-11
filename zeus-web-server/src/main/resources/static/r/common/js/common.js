Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()
        // millisecond
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};

var GridDateformater = function (value, row, index) {
    var ret = moment(value, 'x').format('YYYY-MM-DD')
    if (ret == "Invalid date") {
        return null;
    } else {
        return ret;
    }
}

jcl_app_json = window.jcl_app_json || {
        env: {
            contextPath: ''
        },
        namespace: function () {
            var o, d;
            for (var i = 0; i < arguments.length; i++) {
                d = arguments[i].split(".");
                o = window[d[0]] = window[d[0]] || {};
                for (var j = 1; j < d.length; j++) {
                    o = o[d[j]] = o[d[j]] || {};
                }
            }
            return o;
        },
        go: function (uri) {
            var url = [jcl.env.contextPath, uri].join('');
            window.location.href = url;
        }
    };
jcl_app_json.ns = jcl_app_json.namespace;
jcl_app_json.ns("jcl_app_json.ui", "jcl_app_json.util");

(function ($) {
    jcl_app_json.Seafood = function (options) {

        var _$this = this;
        var defaults = {
            id: ''
        };
        var opts = $.extend(defaults, options);

        this.openSelf = function (tabs, title, href) {
            tabs.tabs("select", 0);
            var tab = tabs.tabs('getSelected'); // get selected
            // panel
            tabs.tabs('update', {
                tab: tab,
                options: {
                    title: title,
                    content:"<iframe frameborder=0 width='100%' height='100%'"
                            + " marginheight=0 marginwidth=0 scrolling=no "
                            + "src=\""+ href + "\"></iframe>"
/*                    href: href,*/
                }
            });
            tab.panel('refresh');
        };

        this.openNew = function (tabs, title, href) {
            tabs.tabs('add', {
                title: title,
                href: href,
                closable: true
            });
        };

        this.refresh = function (tabs, href) {
            var tab = tabs.tabs('getSelected'); // get selected
            // panel
            tab.panel('refresh', href);
        };

        this.close = function (tabs) {
            var tab = tabs.tabs('getSelected');
            if (tab) {
                var index = tabs.tabs('getTabIndex', tab);
                tabs.tabs('close', index);
            }

        };

        this.loading = function (title, msg) {
            var win = $.messager.progress({
                                              title: title,
                                              msg: msg
                                          });
        };

        this.loadingClose = function () {
            $.messager.progress('close');
        };

        this.showConfirm = function (title, msg, callback) {
            $.messager.confirm(title, msg, function (r) {
                if (r) {
                    if (jQuery.isFunction(callback)) {
                        callback.call();
                    }
                }
            });
        };

        this.show = function (title, msg, showType) {
            $.messager.show({
                                title: title,
                                msg: msg,
                                timeout: 5000,
                                showType: showType
                            });
        };

        this.alert = function (title, msg) {
            $.messager.alert(title, msg);
        };

        this.alert = function (title, msg, showType) {
            $.messager.alert(title, msg, showType);
        };

        this.getDdSelections = function (dg) {
            var ids = [];
            var rows = $(dg).datagrid('getSelections');
            for (var i = 0; i < rows.length; i++) {
                ids.push(rows[i].ID);
            }
            return ids;
        };

        this.getDdCheckSelections = function (dg, status) {
            var ids = [];
            var rows = $(dg).datagrid('getSelections');
            for (var i = 0; i < rows.length; i++) {
                if (rows[i].orderStatus == 10) {
                    $.messager.alert('提示消息', '你选择的数据末付款，请重新选择!', 'warning');
                    return null;
                }
                if (status <= rows[i].orderStatus) {
                    $.messager.alert('提示消息', '你选择的数据不能处理，请重新选择!', 'warning');
                    return null;
                }
                ids.push(rows[i].id);
            }
            return ids;
        };
    }
    jcl_app_json.tbTool = function (options) {
        jqueryTbSelector = options.jobj;
        this.create = function (detailViewPageUrl) {
            //初始化复杂详情字段
            $(jqueryTbSelector).datagrid({
                                            url:options.list,
                                             view: detailview,
                                             detailFormatter: function (index, row) {
                                                 return '<div class="ddv"></div>';
                                             },
                                             onExpandRow: function (index, row) {
                                                 var THIS = $(this)
                                                 var ddv = $(this)
                                                     .datagrid('getRowDetail', index)
                                                     .find('div.ddv');
                                                 ddv.panel({
                                                               border: false,
                                                               cache: true,
                                                               href: options.detailPage,
                                                               onLoad: function () {
                                                                   THIS.datagrid(
                                                                       'fixDetailRowHeight',
                                                                       index);
                                                                   THIS.datagrid('selectRow',
                                                                                 index);
                                                                   var form = THIS.datagrid(
                                                                       'getRowDetail',
                                                                       index)
                                                                       .find('form')
                                                                   form.form('load', row);
                                                               }
                                                           });
                                                 THIS.datagrid('fixDetailRowHeight', index);
                                             }
                                         });
        }

        this.saveItem = function (index) {
            var row = $(jqueryTbSelector).datagrid('getRows')[index];
            var url = row.isNewRecord ? options.add : options.update;
            var detail = $(jqueryTbSelector).datagrid('getRowDetail', index).find('form')

            if (!detail.form('enableValidation').form('validate')) {
                s.alert('提示消息', '数据验证错误！', 'error');
                return;
            }

            $.ajax({
                       url: url,
                       data: detail.serialize(),
                       type: "POST",
                       dataType: "json",
                       async: true,
                       success: function (data) {
                           if (!data.success) {
                               s.show('提示消息', '保存失败!', 'slide');
                           } else {
                               data.isNewRecord = false;
                               $(jqueryTbSelector).datagrid('collapseRow', index);
                               $(jqueryTbSelector).datagrid('updateRow', {
                                   index: index,
                                   row: data
                               });
                               $(jqueryTbSelector).datagrid('reload');
                               s.alert('提示消息', '保存成功!', 'error');
                           }
                       }
                   });
        }

        this.cancelItem = function (index) {
            var row = $(jqueryTbSelector).datagrid('getRows')[index];
            if (row.isNewRecord) {
                $(jqueryTbSelector).datagrid('deleteRow', index);
            } else {
                $(jqueryTbSelector).datagrid('collapseRow', index);
            }
        }

        this.destroyItem = function (index) {
            var row = $(jqueryTbSelector).datagrid('getSelected');
            if (index != "" && index != null) {
                row = $(jqueryTbSelector).datagrid('getRows')[index];
            }
            if (row) {
                $.messager.confirm('确认删除', '是否真的要删除?', function (r) {
                    if (r) {
                        var index = $(jqueryTbSelector).datagrid('getRowIndex', row);
                        $.post(options.del, {id: row.id}, function () {
                            $(jqueryTbSelector).datagrid('deleteRow', index);
                        });
                    }
                });
            }
        }

        this.newItem = function () {
            $(jqueryTbSelector).datagrid('appendRow', {isNewRecord: true});
            var index = $(jqueryTbSelector).datagrid('getRows').length - 1;
            $(jqueryTbSelector).datagrid('expandRow', index);
            $(jqueryTbSelector).datagrid('selectRow', index);
        }

        this.search = function(value,name){
            var searchObj = {};
            if(value != NaN && value != "") {
                searchObj[name] = value;
            }
            $(jqueryTbSelector).datagrid('load',searchObj);

        }
    }

/*    $.fn.datebox.defaults.formatter = function (date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y+"-"+m+"-"+d;
    }*/

    $.fn.datetimebox.defaults.parser = function (s) {
        if (!isNaN(s)) {
            return new Date(s)
        } else {
            return new Date();
        }
    }
})(jQuery);

