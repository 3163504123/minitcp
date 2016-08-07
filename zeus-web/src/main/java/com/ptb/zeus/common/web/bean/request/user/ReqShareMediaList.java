package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by eric on 16/5/28.
 */
public class ReqShareMediaList {
    @NotBlank(message = "分享KEY不能为空")
    String key;

    public ReqShareMediaList(String key) {
        this.key = key;
    }

    public ReqShareMediaList() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
