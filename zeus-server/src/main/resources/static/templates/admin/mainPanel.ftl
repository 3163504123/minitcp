<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tree Actions - jQuery EasyUI Demo</title>
<#include "commonHead.ftl"/>
</head>
<body class="easyui-layout">
<#include "header.ftl"/>
<div region="west" split="true" title="导航" style="width:200px;padding: 0px;">
    <div class="easyui-accordion" data-options="multiple:true,selected:false,fit:true"
         border="false" style="witdh:100%">
        <div title="运营管理" style="overflow:auto;padding:10px;">
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "百宝箱管理", "/static/r/demo/application/f1.html")'>百宝箱管理</a>
                </dd>
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "视频管理", "/upgrade/channel")'>渠道</a>
                </dd>
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "用户管理", "/upgrade/channel")'>渠道</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
<div data-options="region:'center',title:''" data-options="fit:true"
     style="overflow-x: hidden; overflow-y: auto; ">
    <div id="center_tabs" class="easyui-tabs" data-options="fit:true"
         style="width:100%; overflow-x: hidden; overflow-y: auto; ">
        <div title="欢迎光临" style="padding:10px">
            <p style="font-size:14px">
                欢迎使用 <strong class="green"> minitcp
                <small>(v1.0.0)</small>
            </strong>，后台管理系统。
            </p>
            <ul>
                <li>版本更新说明</li>
                <li>更新日志</li>
            </ul>
        </div>
    </div>
</div>
<#include "footer.ftl"/>
</body>
</html>