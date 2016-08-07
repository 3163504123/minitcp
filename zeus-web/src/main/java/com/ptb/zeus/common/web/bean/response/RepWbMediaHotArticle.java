package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.WbMediaHotArticleBean;

import java.util.List;

/**
 * 微博媒体热文
 * @author lenovo
 *
 */
public class RepWbMediaHotArticle {

	private int totalNum;
	private List<WbMediaHotArticleBean> list;
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public List<WbMediaHotArticleBean> getList() {
		return list;
	}
	public void setList(List<WbMediaHotArticleBean> list) {
		this.list = list;
	}

}
