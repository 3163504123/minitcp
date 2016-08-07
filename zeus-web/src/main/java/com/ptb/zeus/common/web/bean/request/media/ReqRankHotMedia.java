package com.ptb.zeus.common.web.bean.request.media;

import com.ptb.zeus.common.web.bean.request.base.ReqStartEnd;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * Created by MyThinkpad on 2016/5/24.
 */
public class ReqRankHotMedia extends ReqStartEnd {

    @NotNull(message = "热文维度不能为空")
    private String rtype;

    @Range(min = 1, max = 2, message = "不支持此平台")
    private int type;


    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean bisWeixin() {
        return type == 1;
    }

    public boolean bisWeibo() {
        return type == 2;
    }

    public boolean bisRead() {
        return rtype.equals("read");
    }

    public boolean bisZan() {
        return rtype.equals("zan");
    }

    public boolean bisSpread() {
        return rtype.equals("spread");
    }

    public boolean bisComment() {
        return rtype.equals("comment");
    }

    public static boolean verifyParam(ReqRankHotMedia reqRankHotMedia) {
        boolean ret = false;
        if (1 == reqRankHotMedia.getType() &&
                (reqRankHotMedia.getRtype().equals("read") || reqRankHotMedia.getRtype().equals("zan"))) {
            ret = true;
        } else if (2 == reqRankHotMedia.getType() &&
                (reqRankHotMedia.getRtype().equals("spread")
                        || reqRankHotMedia.getRtype().equals("zan")
                        || reqRankHotMedia.getRtype().equals("comment"))) {
            ret = true;
        } else {

        }
        return ret;
    }
}