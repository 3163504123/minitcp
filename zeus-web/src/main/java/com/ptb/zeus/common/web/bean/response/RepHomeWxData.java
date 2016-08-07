package com.ptb.zeus.common.web.bean.response;

/**
 * 微信首页weixin
 * @author lenovo
 *
 */
public class RepHomeWxData {
	
	private int mediaNum;
	private RepHomeWxRank rankList;
	private RepHomeWxHotArticle hotArticle;

	public int getMediaNum() {
		return mediaNum;
	}

	public void setMediaNum(int mediaNum) {
		this.mediaNum = mediaNum;
	}

	public RepHomeWxRank getRankList() {
		return rankList;
	}

	public void setRankList(RepHomeWxRank rankList) {
		this.rankList = rankList;
	}

	public RepHomeWxHotArticle getHotArticle() {
		return hotArticle;
	}

	public void setHotArticle(RepHomeWxHotArticle hotArticle) {
		this.hotArticle = hotArticle;
	}
}
