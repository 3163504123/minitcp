package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by eric on 16/6/6.
 */
public class ReqUpdateTag extends ReqPmidType {

    @NotBlank(message = "标签不能为空")
    @Size(min = 1, max = 15, message = "标签长度应为1到15个字符")
    private String tag;


    @Size(min = 1, max = 15, message = "新标签长度应为1到15个字符")
    @NotBlank(message = "标签不能为空")
    private String newtag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNewtag() {
        return newtag;
    }

    public void setNewtag(String newtag) {
        this.newtag = newtag;
    }
}
