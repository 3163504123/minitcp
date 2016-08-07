package com.ptb.zeus.common.web.bean.request.base;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * Created by eric on 16/6/5.
 */
public class ReqPmidType {
    @NotBlank(message = "媒体ID不能为空")
    protected
    String pMid;
    @Range(min = 1, max = 2, message = "平台类型不正确")
    protected
    int type;

    public String getpMid() {
        return pMid;
    }

    public void setpMid(String pMid) {
        this.pMid = pMid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
