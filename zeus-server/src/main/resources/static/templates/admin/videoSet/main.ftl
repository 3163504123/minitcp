<!DOCTYPE html>
<html style="height: 100%;">
<head>

    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "../common/commHeader.ftl"/>
</head>
<body style="height: 100%">
<div class="easyui-layout" style="width:100%;height: 100%">
    <div region="center">
        <table id="tb-mvedio-set" class="easyui-datagrid"
               iconCls="icon-save"
               rownumbers="true" fit="true" fitColumns="true"
               loadMsg="加载数据....."
               pagination="true" toolbar="#tb-mvedio-set-toolbox" singleSelect="true"
               >
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th data-options="field:'id',resizable:'true',sortable:'true'">id</th>
                <th data-options="field:'name',resizable:'true',sortable:'true'">名称</th>
                <th data-options="field:'instruction',resizable:'true',sortable:'true'">介绍</th>
                <th data-options="field:'imgUrl',resizable:'true',sortable:'true'">封面图</th>
                <th data-options="field:'studyLevel',resizable:'true',sortable:'true'">学习难度</th>
                <th data-options="field:'teacherId',resizable:'true',sortable:'true'">教师ID</th>
                <th data-options="field:'studentCnt',resizable:'true',sortable:'true'">学生人数</th>
                <th data-options="field:'utime',sortable:'true',formatter:GridDateformater"
                ">更新时间</th>
                <th data-options="field:'ctime',sortable:'true',formatter:GridDateformater"
                ">创建时间</th>
            </tr>
            </thead>
        </table>
        <div id="tb-mvedio-set-toolbox">
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
        jobj: "#tb-mvedio-set",
        list: "/admin/api/videoSet/list",
        add: "/admin/api/videoSet/add",
        update: "/admin/api/videoSet/update",
        del: "/admin/api/videoSet/del",
        detailPage: "/admin/videoSet/edit"
    });
    tbtool.create("/admin/api/videoSet/list")
</script>
</body>
</html>