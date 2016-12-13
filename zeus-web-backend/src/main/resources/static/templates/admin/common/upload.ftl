<div id="dlg-uploadFile" class="easyui-dialog" style="padding:5px;width:400px;height:200px;"
     title="上传封面图" iconCls="icon-ok" buttons="#dlg-buttons" closed="true">
    <div style="margin: 45px 50px">
        <input id="uploadFile" type="file" name="file1" style="width: 300px;"/>
    </div>
</div>

<script>

    /*上传文件组件*/
    function ajaxFileUpload() {
        $.ajaxFileUpload
        (
                {
                    url: '/upload', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    fileElementId: 'uploadFile', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    data:{ Id: '123', fileType: 'lunis' },
                    success: function (data)  //服务器成功响应处理函数
                    {
                        $('#imgUrl').val(data.data)
                        $('#dlg-uploadFile').dialog('close')
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
        )
        return false;
    }
</script>

<#--上传封面图组件代码开始-->

<div id="dlg-buttons">
    <table cellpadding="0" cellspacing="0" style="width:100%">
        <tr>
            <td style="text-align:right">
                <a href="#" class="easyui-linkbutton" iconCls="icon-save"
                   onclick="ajaxFileUpload()">上传</a>
                <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
                   onclick="$('#dlg-uploadFile').dialog('close')">取消</a>
            </td>
        </tr>
    </table>
</div>
<#--上传封面图组件代码结束-->