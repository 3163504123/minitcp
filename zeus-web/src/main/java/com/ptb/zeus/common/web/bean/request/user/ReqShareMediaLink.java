package com.ptb.zeus.common.web.bean.request.user;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * Created by eric on 16/5/28.
 */
public class ReqShareMediaLink {
    @Range(min = 1,max = 2,message = "平台类型不正确")
    int type;

    @NotEmpty(message = "分享媒体ID不能为空")
    List<String> pMids;

    public ReqShareMediaLink(int type, List<String> pMids) {
        this.type = type;
        this.pMids = pMids;
    }

    public ReqShareMediaLink() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getpMids() {
        return pMids;
    }

    public void setpMids(List<String> pMids) {
        this.pMids = pMids;
    }
}
