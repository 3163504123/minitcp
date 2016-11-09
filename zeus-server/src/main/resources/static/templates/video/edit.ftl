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
            <td>ID</td>
            <td><input name="id" readonly></input>
            </td>
            <td>名称</td>
            <td><input name="name" class="easyui-validatebox"/></td>
        </tr>
        <tr>
            <td>资源地址</td>
            <td><input name="resourceUrl" class="easyui-validatebox" ></input>
            </td>
            <td>观看次数</td>
            <td><input name="uv" class="easyui-numberbox" ></input>
            </td>
        </tr>
        <tr>
            <td>介绍</td>
            <td><textarea name="instruction" rows="4" cols="40"></textarea>
            </td>
        </tr>

        <tr style="display: none;">
            <td>创建时间</td>
            <td>
                <input class="easyui-datetimebox" name="ctime"
                       data-options="showSeconds:true"/>
            </td>
        </tr>
    </table>
    <div style="padding:5px 0;text-align:right;padding-right:30px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true"
           onclick="save1(this)">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
           onclick="cancel1(this)">Cancel</a>
    </div>
</form>
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