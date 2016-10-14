Date.prototype.format = function(format) {
    var o = {
        "M+" : this.getMonth() + 1, // month
        "d+" : this.getDate(), // day
        "h+" : this.getHours(), // hour
        "m+" : this.getMinutes(), // minute
        "s+" : this.getSeconds(), // second
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
        "S" : this.getMilliseconds()
        // millisecond
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};
jcl_app_json = window.jcl_app_json || {
        env : {
            contextPath : ''
        },
        namespace : function() {
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
        go : function(uri) {
            var url = [ jcl.env.contextPath, uri ].join('');
            window.location.href = url;
        }
    };
jcl_app_json.ns = jcl_app_json.namespace;
jcl_app_json.ns("jcl_app_json.ui", "jcl_app_json.util");

(function($) {
    jcl_app_json.Seafood = function(options) {

        var _$this = this;
        var defaults = {
            id : ''
        };
        var opts = $.extend(defaults, options);

        this.openSelf = function(tabs, title, href) {
            tabs.tabs("select", 0);
            var tab = tabs.tabs('getSelected'); // get selected
            // panel
            tabs.tabs('update', {
                tab : tab,
                options : {
                    title : title,
                    href : href,
                }
            });
            tab.panel('refresh', href);
        };

        this.openNew = function(tabs, title, href) {
            tabs.tabs('add', {
                title : title,
                href : href,
                closable : true
            });
        };

        this.refresh = function(tabs, href) {
            var tab = tabs.tabs('getSelected'); // get selected
            // panel
            tab.panel('refresh', href);
        };

        this.close = function(tabs) {
            var tab =tabs.tabs('getSelected');
            if (tab) {
                var index =tabs.tabs('getTabIndex', tab);
                tabs.tabs('close', index);
            }

        };

        this.loading = function(title, msg) {
            var win = $.messager.progress({
                                              title:title,
                                              msg:msg
                                          });
        };

        this.loadingClose = function() {
            $.messager.progress('close');
        };


        this.showConfirm = function(title, msg, callback) {
            $.messager.confirm(title, msg, function (r) {
                if (r) {
                    if (jQuery.isFunction(callback))
                        callback.call();
                }
            });
        };

        this.show = function(title, msg, showType) {
            $.messager.show({
                                title:title,
                                msg:msg,
                                timeout:5000,
                                showType:showType
                            });
        };

        this.alert = function(title, msg) {
            $.messager.alert(title,msg);
        };

        this.alert = function(title, msg, showType) {
            $.messager.alert(title,msg, showType);
        };

        this.getDdSelections = function(dg) {
            var ids = [];
            var rows = $(dg).datagrid('getSelections');
            for(var i=0; i<rows.length; i++){
                ids.push(rows[i].ID);
            }
            return ids;
        };

        this.getDdCheckSelections = function(dg, status) {
            var ids = [];
            var rows = $(dg).datagrid('getSelections');
            for(var i=0; i<rows.length; i++){
                if (rows[i].orderStatus == 10) {
                    $.messager.alert('提示消息','你选择的数据末付款，请重新选择!', 'warning');
                    return null;
                }
                if (status <= rows[i].orderStatus) {
                    $.messager.alert('提示消息','你选择的数据不能处理，请重新选择!', 'warning');
                    return null;
                }
                ids.push(rows[i].id);
            }
            return ids;
        };
    }

})(jQuery);
