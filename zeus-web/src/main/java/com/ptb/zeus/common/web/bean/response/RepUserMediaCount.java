package com.ptb.zeus.common.web.bean.response;

/**
 * Created by eric on 16/6/1.
 */
public class RepUserMediaCount {

    private int totalNum;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public RepUserMediaCount(int userMediaCount) {
        this.totalNum = userMediaCount;
    }
}
