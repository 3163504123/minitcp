package com.ptb.zeus.common.web.bean.request.media;

import org.hibernate.validator.constraints.Range;

/**
 * Created by eric on 16/6/1.
 */
public class ReqUserMediaCount {
    @Range(min = 1,max = 2,message = "平台类型不正确")
    int type;

    public ReqUserMediaCount(int type) {
        this.type = type;
    }

    public ReqUserMediaCount() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
