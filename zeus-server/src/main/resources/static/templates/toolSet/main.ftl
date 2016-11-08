<!DOCTYPE html>
<html>
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body>
<div class="easyui-layout" style="min-height:500px;width:100%;height: 100%">
    <div region="center">
        <table id="tb-mtool-set" class="easyui-datagrid"
               iconCls="icon-save"
               rownumbers="true" fit="true" fitColumns="true"
               loadMsg="加载数据....."
               pagination="true" toolbar="#tb-mtool-set-toolbox" singleSelect="true"
               style="height: 100%">
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th data-options="field:'id',resizable:'true',sortable:'true'">id</th>
                <th data-options="field:'name',resizable:'true',sortable:'true'">名称</th>
                <th data-options="field:'ctime',sortable:'true',formatter:GridDateformater"
                ">创建时间</th>
            </tr>
            </thead>
        </table>
        <div id="tb-mtool-set-toolbox">
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
        jobj: "#tb-mtool-set",
        list: "/api/toolSet/list",
        add: "/api/toolSet/add",
        update: "/api/toolSet/update",
        del: "/api/toolSet/del",
        detailPage: "/toolSet/edit"
    });
    tbtool.create("api/toolSet/list")
</script>
</body>
</html>