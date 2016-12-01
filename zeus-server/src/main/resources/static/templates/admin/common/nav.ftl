<div region="west" split="true" title="导航" style="width:200px;padding: 0px;">
    <div class="easyui-accordion" data-options="multiple:false,selected:false,fit:true"
         border="false" style="witdh:100%">
        <div title="百宝箱管理" style="overflow:auto;padding:10px;">
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "API分类管理", "${basePath}/admin/toolSet")'>分类管理</a>
                </dd>
            </dl>
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "API管理", "${basePath}/admin/tool")'>API管理</a>
                </dd>
            </dl>
        </div>
        <div title="视频管理" style="overflow:auto;padding:10px;">
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "分集管理", "${basePath}/admin/video")'>视频管理</a>
                </dd>
            </dl>
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "视频集管理", "${basePath}/admin/videoSet")'>视频集</a>
                </dd>
            </dl>
        </div>
        <div title="主营管理" style="overflow:auto;padding:10px;">
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "用户管理", "${basePath}/admin/u")'>用户管理</a>
                </dd>
            </dl>
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "商品管理", "${basePath}/admin/product")'>商品管理</a>
                </dd>
            </dl>
            <dl class="hx_admin_subnav">
                <dd>
                    <a href="#"
                       onclick='addclass(this);s.openSelf($("#center_tabs"), "用户服务", "${basePath}/admin/userService")'>用户服务</a>
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