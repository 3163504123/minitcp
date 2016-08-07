package com.ptb.zeus.common.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyThinkpad on 2016/5/25.
 */
public class ArticleSet {
    public static final ArticleSet Null = new ArticleSet(0, new ArrayList());
    private int total;
    private List<ArticleDetail> articleDetailList;

    public ArticleSet() {
    }

    public ArticleSet(int total, List<ArticleDetail> articleDetailList) {
        this.total = total;
        this.articleDetailList = articleDetailList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ArticleDetail> getArticleDetailList() {
        return articleDetailList;
    }

    public void setArticleDetailList(List<ArticleDetail> articleDetailList) {
        this.articleDetailList = articleDetailList;
    }
}
