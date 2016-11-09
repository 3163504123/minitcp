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
            <td>介绍</td>
            <td><input name="instruction"></input>
            </td>
            <td>学习层次</td>
            <td>
                <select class="easyui-combobox" name="studyLevel">
                    <option value="0">初级</option>
                    <option value="1">中级</option>
                    <option value="2">高级</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>教师ID</td>
            <td><input name="teacherId"></input>
            </td>
            <td>背景图</td>
            <td><input name="imgUrl" class="easyui-validatebox"/></td>
        </tr>
        <tr>
            <td>学生人数</td>
            <td><input name="studentCnt" class="easyui-numberbox" ></input>
            </td>
        </tr>

        <tr style="display: none;">
            <td>更新时间</td>
            <td>
                <input class="easyui-datetimebox" name="utime"
                       data-options="showSeconds:true"/>
            </td>
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