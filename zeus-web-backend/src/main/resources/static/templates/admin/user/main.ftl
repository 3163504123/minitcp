<!DOCTYPE html>
<html>
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body>
<div class="easyui-layout" style="min-height:500px;width:100%;height: 100%">
    <div region="center">
        <table id="tb-user" class="easyui-datagrid"
               url="/admin/api/u/list" iconCls="icon-save"
               rownumbers="true" fit="true" fitColumns="true"
               loadMsg="加载数据....."
               pagination="true" toolbar="#tb-user-toolbox" singleSelect="true"
               style="height: 100%">
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th data-options="field:'uname',resizable:'true',sortable:'true'">用户名</th>
                <th data-options="field:'password',sortable:'true'">密码</th>
                <th data-options="field:'ph',sortable:'true'">手机号</th>
                <th data-options="field:'email',sortable:'true'">邮箱</th>
                <th data-options="field:'ctime',sortable:'true',formatter:GridDateformater"
                ">创建时间</th>
                <th data-options="field:'state',sortable:'true'">状态</th>
                <th data-options="field:'nickName',sortable:'true'">昵称</th>
                <th data-options="field:'remark',sortable:'true'">备注</th>
            </tr>
            </thead>
        </table>
        <div id="tb-user-toolbox">
            <input id="tb-search" class="easyui-searchbox" style="width:200px;margin-right: 10px"
                   data-options="searcher:tbtool.search,prompt:'输入查询的内容',menu:'#mm'"></input>
            <div id="mm" style="width:50px">
                <div data-options="name:'id'">ID</div>
                <div data-options="name:'email'">邮箱</div>
            </div>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
               onclick="tbtool.newItem()">新建</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove"
               plain="true" onclick="tbtool.destroyItem()">删除</a>
        </div>
    </div>
</div>
<script>
    var tbtool = new jcl_app_json.tbTool({
        jobj: "#tb-user",
        list: "${basePath}/admin/api/u/list",
        add: "${basePath}/admin/api/u/add",
        update: "${basePath}/admin/api/un/update",
        del: "${basePath}/admin/api/u/del",
        detailPage: "${basePath}/admin/u/edit"
    });
    tbtool.create("${basePath}/admin/api/un/list")
</script>
</body>
</html>