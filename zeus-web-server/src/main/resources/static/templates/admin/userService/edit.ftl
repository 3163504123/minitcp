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
            <td><input name="id" readonly/>
            </td>
            <td>用户ID</td>
            <td><input name="uid" class="easyui-validatebox"/></td>
        </tr>
        <tr>

            <td>服务KEY</td>
            <td><input name="skey" class="easyui-validatebox" readonly/></td>
            <td>产品ID</td>
            <td><input name="pId" class="easyui-validatebox" readonly/></td>
        </tr>
        <tr>
            <td>剩余次数</td>
            <td><input name="costNum" class="easyui-validatebox" readonly/></td>
            <td>初始化次数</td>
            <td><input name="initNum" class="easyui-validatebox" readonly/></td>
        </tr>

        <tr>
            <td>服务截至时间</td>
            <td><input name="deadlineTime" class="easyui-validatebox" readonly/></td>
            <td>服务开始时间</td>
            <td><input name="initTime" class="easyui-validatebox" readonly/></td>
        </tr>
        <tr>
            <td>结算方式</td>
            <td><input name="method" class="easyui-validatebox" readonly/></td>
            <td>是否可用</td>
            <td><input name="method" class="easyui-numberbox" readonly/></td>
        </tr>
        <tr style="display: none ;">
            <td>创建时间</td>
            <td>
                <input class="easyui-datetimebox" name="ctime"
                       data-options="showSeconds:true" style="width:150px"/>
            </td>
        </tr>
    </table>
    <div style="padding:5px 0;text-align:center;padding-right:30px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true"
           onclick="save1(this)">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
           onclick="cancel1(this)">取消</a>
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