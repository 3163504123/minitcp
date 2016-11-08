<!DOCTYPE html>
<html>
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body>
<div class="easyui-layout" style="min-height:620px;width:100%;height: 100%">
    <div region="center" style="height: 100%">
        <table id="tb-mtool" class="easyui-datagrid"
               iconCls="icon-save"
               rownumbers="true" fit="true" fitColumns="true"
               loadMsg="加载数据....."
               pagination="true" toolbar="#tb-mtool-toolbox" singleSelect="true"
               style="height: 100%">
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th data-options="field:'id',resizable:'true',sortable:'true'">id</th>
                <th data-options="field:'name',resizable:'true',sortable:'true'">名称</th>
                <th data-options="field:'instruction',resizable:'true',sortable:'true'">介绍</th>
                <th data-options="field:'state',resizable:'true',sortable:'true'">状态</th>
                <th data-options="field:'price',resizable:'true',sortable:'true'">价格</th>
                <th data-options="field:'demoUrl',resizable:'true',sortable:'true'">演示地址</th>
                <th data-options="field:'imgUrl',resizable:'true',sortable:'true'">封面图地址</th>
                <th data-options="field:'apiDescUrl',resizable:'true',sortable:'true'">API介绍URL</th>
                <th data-options="field:'vedioUrl',resizable:'true',sortable:'true'">教程视频地址</th>
                <th data-options="field:'useCnt',resizable:'true',sortable:'true'">当前使用次数</th>
                <th data-options="field:'usedUserCnt',resizable:'true',sortable:'true'">当前使用人数</th>
                <th data-options="field:'ctime',sortable:'true',formatter:GridDateformater"
                ">创建时间</th>

            </tr>
            </thead>
        </table>
        <div id="tb-mtool-toolbox">
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
        jobj: "#tb-mtool",
        list: "/api/tool/list",
        add: "/api/tool/add",
        update: "/api/tool/update",
        del: "/api/tool/del",
        detailPage: "/tool/edit"
    });
    tbtool.create("api/tool/list")
</script>
</body>
</html>