package com.ptb.zeus.common.web.bean.response;

/**
 * 微博首页
 * @author lenovo
 *
 */
public class RepHomeWbData {
	
	private int mediaNum ;
	private RepHomeWbRank rankList;
	private RepHomeWbHotArticle hotArticle;

	public int getMediaNum() {
		return mediaNum;
	}

	public void setMediaNum(int mediaNum) {
		this.mediaNum = mediaNum;
	}

	public RepHomeWbRank getRankList() {
		return rankList;
	}

	public void setRankList(RepHomeWbRank rankList) {
		this.rankList = rankList;
	}

	public RepHomeWbHotArticle getHotArticle() {
		return hotArticle;
	}

	public void setHotArticle(RepHomeWbHotArticle hotArticle) {
		this.hotArticle = hotArticle;
	}
}
