package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.Range;

/**
 * Created by eric on 16/5/29.
 */
public class ReqTagList {
    @Range(min = 0,max = 2,message = "平台类型不正确")
    private int type;

    public ReqTagList(int type) {
        this.type = type;
    }

    public ReqTagList() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
