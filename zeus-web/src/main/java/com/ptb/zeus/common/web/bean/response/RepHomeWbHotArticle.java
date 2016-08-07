package com.ptb.zeus.common.web.bean.response;

import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWbHotArticle {
    private int totalNum;
    private List<RepHomeWbArticle> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<RepHomeWbArticle> getList() {
        return list;
    }

    public void setList(List<RepHomeWbArticle> list) {
        this.list = list;
    }
}
