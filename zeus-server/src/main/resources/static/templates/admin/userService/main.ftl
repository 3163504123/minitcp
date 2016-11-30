<!DOCTYPE html>
<html style="height: 100%;">
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body style="height: 100%">
<div class="easyui-layout" style="width:100%;height: 100%">
    <div region="center" style="height: 100%">
        <table id="tb-mUserService" class="easyui-datagrid"
               iconCls="icon-save"
               rownumbers="true" fit="true" fitColumns="true"
               loadMsg="加载数据....."
               pagination="true" toolbar="#tb-mUserService-toolbox" singleSelect="true"
               style="height: 100%">
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th data-options="field:'id',resizable:'true',sortable:'true'">id</th>
                <th data-options="field:'uid',resizable:'true',sortable:'true'">用户名</th>
                <th data-options="field:'skey',resizable:'true',sortable:'true'">服务KEY</th>
                <th data-options="field:'pId',resizable:'true',sortable:'true'">产品ID</th>
                <th data-options="field:'costNum',resizable:'true',sortable:'true'">剩余次数</th>
                <th data-options="field:'initNum',resizable:'true',sortable:'true'">已使用次数</th>
                <th data-options="field:'method',resizable:'true',sortable:'true'">结算方式</th>
                <th data-options="field:'deadlineTime',sortable:'true',formatter:GridDateformater">服务截至时间</th>
                <th data-options="field:'ctime',sortable:'true',formatter:GridDateformater">服务创建时间</th>
            </tr>
            </thead>
        </table>
        <div id="tb-mUserService-toolbox">
            <input id="tb-search" class="easyui-searchbox" style="width:200px;margin-right: 10px"
                   data-options="searcher:tbtool.search,prompt:'输入查询的内容',menu:'#mm'"></input>
            <div id="mm" style="width:50px">
                <div data-options="name:'id'">ID</div>
                <div data-options="name:'name'">名字</div>
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
        jobj: "#tb-mUserService",
        list: "/admin/api/userService/list",
        add: "/admin/api/userService/add",
        update: "/admin/api/userService/update",
        del: "/admin/api/userService/del",
        detailPage: "/admin/userService/edit"
    });
    tbtool.create("/admin/api/userService/list")
</script>
</body>
</html>