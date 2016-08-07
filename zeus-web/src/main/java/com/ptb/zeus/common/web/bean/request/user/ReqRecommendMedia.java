package com.ptb.zeus.common.web.bean.request.user;

import com.ptb.zeus.common.web.bean.request.base.ReqStartEnd;

import org.hibernate.validator.constraints.Range;

/**
 * Created by eric on 16/7/18.
 */
public class ReqRecommendMedia extends ReqStartEnd {
    @Range(min = 1,max = 2,message = "平台类型不正确")
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
