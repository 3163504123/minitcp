package com.ptb.zeus.common.web.bean.request.media;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * 标签
 *
 * @author lenovo
 */
public class ReqTag extends ReqPmidType {

    @NotBlank(message = "标签不能为空")
    @Size(min = 1, max = 15, message = "新标签长度应为1到15个字符")
    private String tag;
    

	public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
