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
            <td><input name="id"/>
            </td>
            <td>名称</td>
            <td><input name="name" class="easyui-validatebox"/></td>
        </tr>
        <tr>

            <td>使用次数</td>
            <td><input name="useCnt" class="easyui-validatebox" readonly/></td>
            <td>状态</td>
            <td>
                <select id="cc" class="easyui-combobox" name="state" style=”width:200px;”>
                    <option value="1">可用</option>
                    <option value="0">不可用</option>
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
                <a class="easyui-linkbutton" iconCls="icon-add"
                   onclick="$('#dlg-uploadFile').dialog('open')">上传</a>
            </td>
            <td>API介绍</td>
            <td><input name="apiDescUrl" class="easyui-validatebox"/></td>
        </tr>
        <tr>
            <td>视频地址</td>
            <td><input name="vedioUrl" class="easyui-validatebox"/></td>
            <td>简介</td>
            <td>
                <textarea name="instruction" rows="2" cols="20"/>
            </td>
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
           onclick="save1(this)">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" plain="true"
           onclick="cancel1(this)">取消</a>
    </div>
</form>

<#include "../common/upload.ftl"/>
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