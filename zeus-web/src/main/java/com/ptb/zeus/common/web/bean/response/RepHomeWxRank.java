package com.ptb.zeus.common.web.bean.response;

import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWxRank {
    private int totalNum;
    private List<RepHomeWxBasic> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<RepHomeWxBasic> getList() {
        return list;
    }

    public void setList(List<RepHomeWxBasic> list) {
        this.list = list;
    }
}

