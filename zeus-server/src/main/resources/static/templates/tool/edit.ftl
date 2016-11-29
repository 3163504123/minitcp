<!DOCTYPE html>
<html>
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body>
<form method="post">
    <table class="dv-table" style="width:100%;background:#fafafa;padding:5px;margin-top:5px;">
        <tr>
            <td>id</td>
            <td><input name="id" readonly></input>
            </td>
            <td>名称</td>
            <td><input name="name" class="easyui-validatebox"/></td>
        </tr>
        <tr>
            <td>简介</td>
            <td><input name="instruction"></input>
            </td>
            <td>状态</td>
            <td>
                <select id=”cc” class=”easyui-combobox” name=”state” style=”width:200px;”>
                    <option value=”0”>可用</option>
                    <option value=”1”>不可用</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>价格</td>
            <td>
                <input type="text" name="price" class="easyui-numberbox" value="100"
                       data-options="min:0,precision:0">
            </td>
            <td>演示地址</td>
            <td><input name="demoUrl" class="easyui-validatebox"/></td>
        </tr>
        <tr>
            <td>封面图地址</td>
            <td>
                <input id="imgUrl" name="imgUrl" class="easyui-validatebox" style="width: 80px"/>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
                   onclick="$('#dlg-uploadFile').dialog('open')">上传</a>
            </td>
            <td>API介绍URL地址</td>
            <td><input name="apiDescUrl" class="easyui-validatebox"/></td>
        </tr>
        <tr>
            <td>教学视频地址</td>
            <td><input name="vedioUrl" class="easyui-validatebox"/></td>
            <td>使用次数</td>
            <td><input name="useCnt" class="easyui-validatebox" readonly/></td>
        </tr>

        <tr style="display: none ;">
            <td>使用人数</td>
            <td><input name="usedUserCnt" class="easyui-validatebox" readonly/></td>
            <td>创建时间</td>
            <td>
                <input class="easyui-datetimebox" name="ctime"
                       data-options="showSeconds:true" style="width:150px"/>
            </td>
        </tr>
    </table>
    <div style="padding:5px 0;text-align:center;padding-right:30px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true"
           onclick="save1(this)">上传</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
           onclick="cancel1(this)">取消</a>


    </div>
</form>

<#--上传封面图组件代码开始-->
<div id="dlg-uploadFile" class="easyui-dialog" style="padding:5px;width:400px;height:200px;"
     title="上传封面图" iconCls="icon-ok" buttons="#dlg-buttons" closed="true">
    <div style="margin: 45px 50px">
    <input id="file1" type="file" name="file" style="width: 300px;"/>
    </div>
</div>
<div id="dlg-buttons">
    <table cellpadding="0" cellspacing="0" style="width:100%">
        <tr>
            <td style="text-align:right">
                <a href="#" class="easyui-linkbutton" iconCls="icon-save"
                   onclick="ajaxFileUpload()">上传</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
                   onclick="$('#dlg-uploadFile').dialog('close')">取消</a>
            </td>
        </tr>
    </table>
</div>


<script>
    function ajaxFileUpload() {
        $.ajaxFileUpload
        (
                {
                    url: '/upload', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'file1', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data)  //服务器成功响应处理函数
                    {
                        $('#imgUrl').val(data.data)
                        $('#dlg-uploadFile').dialog('close')
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
        )
        return false;
    }
</script>
<#--上传封面图组件代码结束-->


<script type="text/javascript">
    function save1(target) {
        var tr = $(target).closest('.datagrid-row-detail').closest('tr').prev();
        var index = parseInt(tr.attr('datagrid-row-index'));
        tbtool.saveItem(index);
    }

    function cancel1(target) {
        var tr = $(target).closest('.datagrid-row-detail').closest('tr').prev();
        var index = parseInt(tr.attr('datagrid-row-index'));
        tbtool.cancelItem(index);
    }

</script>
</body>
</html>