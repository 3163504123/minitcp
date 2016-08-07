package com.ptb.zeus.common.web.bean.response;

import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/23.
 */
public class RepHomeWxHotArticle {
    private int totalNum;
    private List<RepHomeWxArticle> list;

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<RepHomeWxArticle> getList() {
        return list;
    }

    public void setList(List<RepHomeWxArticle> list) {
        this.list = list;
    }
}
