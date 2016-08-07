package com.ptb.zeus.common.web.bean.request.common;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 意见反馈
 *
 * @author lenovo
 */
public class ReqFeedback {

    @NotNull(message = "反馈信息不能为空")
    @Size(min = 1,max = 100,message = "消息长度为1-100个字符")
    private String content;
    @NotNull(message = "联系方式不能为空")
    @Size(min = 5,max=20,message = "联系方式长度为5-20个字符")
    private String contact;

    @Size(max = 20, message = "反馈类型太长了")
    private String type;



    public ReqFeedback(String content, String contact) {
        this.content = content;
        this.contact = contact;
    }

    public ReqFeedback() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
