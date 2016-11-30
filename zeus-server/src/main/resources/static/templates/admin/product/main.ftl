<!DOCTYPE html>
<html style="height: 100%;">
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body style="height: 100%">
<div class="easyui-layout" style="width:100%;height: 100%">
    <div region="center" style="height: 100%">
        <table id="tb-mProduct" class="easyui-datagrid"
               iconCls="icon-save"
               rownumbers="true" fit="true" fitColumns="true"
               loadMsg="加载数据....."
               pagination="true" toolbar="#tb-mProduct-toolbox" singleSelect="true"
               style="height: 100%">
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th data-options="field:'id',sortable:'true'">id</th>
                <th data-options="field:'img',resizable:'true',sortable:'true'">图片</th>
                <th data-options="field:'price',sortable:'true'">价格</th>
                <th data-options="field:'name',sortable:'true'">名称</th>
                <th data-options="field:'url',sortable:'true'">详细链接</th>
                <th data-options="field:'ctime',sortable:'true',formatter:GridDateformater"
                ">创建时间</th>
                <th data-options="field:'utime',sortable:'true',formatter:GridDateformater"
                ">更新时间</th>
                <th data-options="field:'des',sortable:'true'">描述</th>
            </tr>
            </thead>
        </table>
        <div id="tb-mProduct-toolbox">
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
        jobj: "#tb-mProduct",
        list: "/admin/api/product/list",
        add: "/admin/api/product/add",
        update: "/admin/api/product/update",
        del: "/admin/api/product/del",
        detailPage: "/admin/product/edit"
    });
    tbtool.create("/admin/api/tool/list")
</script>
</body>
</html>