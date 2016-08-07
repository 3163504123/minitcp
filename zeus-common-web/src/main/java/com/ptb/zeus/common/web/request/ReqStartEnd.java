package com.ptb.zeus.common.web.request;

import org.hibernate.validator.constraints.Range;

/**
 * Created by eric on 16/6/5.
 */
public class ReqStartEnd {
    @Range(min = 0, message = "开始或结果索引不正确")
    protected int start = 0;
    @Range(min = 0, message = "开始或结果索引不正确")
    protected int end = 10;

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
}
