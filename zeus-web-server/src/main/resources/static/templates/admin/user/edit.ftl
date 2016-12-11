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
            <td>用户ID</td>
            <td><input name="id" readonly></input>
            </td>
            <td>状态</td>
            <td><input name="state" class="easyui-validatebox" /></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input name="uname" class="easyui-validatebox" required="true" autocomplete="off"></input></td>
            <td>密码</td>
            <td><input name="password" type="password" class="easyui-validatebox" autocomplete="off" required="true"></input></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input name="ph"></input></td>
            <td>邮箱</td>
            <td><input name="email" class="easyui-validatebox"></input></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input name="nickName" class="easyui-validatebox"></input></td>
            <td>备注</td>
            <td><input name="remark"></input></td>
        </tr>
        <tr style="display: true;">
            <td>创建时间</td>
            <td>
                <input class="easyui-datetimebox" name="ctime"
                       data-options="showSeconds:true" style="width:150px"/>
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