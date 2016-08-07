package com.ptb.zeus.common.web.bean.request.media;

import com.ptb.zeus.common.web.bean.request.base.ReqPmidType;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

public class ReqMediaArticleList extends ReqPmidType {

    @Range(min = 0, max = Integer.MAX_VALUE, message = "开始或结果索引错误")
    private int start = 0;
    @Range(min = 0, max = Integer.MAX_VALUE, message = "开始或结果索引错误")
    private int end = 10;
    @NotBlank(message = "文章类型不能为空")
    @Size(min = 1, max = 10, message = "文章类型应为1-10个字符")
    private String atype;

    public ReqMediaArticleList(int start, int end, int type, String atype, String pMid) {
        this.start = start;
        this.end = end;
        this.atype = atype;
        this.type = type;
        this.pMid = pMid;
    }

    public ReqMediaArticleList() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }
}
