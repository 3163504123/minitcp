package com.ptb.zeus.common.web.bean.response;

import java.util.List;

/**
 * Created by eric on 16/5/28.
 */
public class RepArticles<T> {
    int totalNum;
    List<T> list;
    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
