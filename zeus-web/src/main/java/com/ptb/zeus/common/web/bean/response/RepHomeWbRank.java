package com.ptb.zeus.common.web.bean.response;

import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWbRank {
    private int totalNum;
    private List<RepHomeWbBasic> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<RepHomeWbBasic> getList() {
        return list;
    }

    public void setList(List<RepHomeWbBasic> list) {
        this.list = list;
    }
}
