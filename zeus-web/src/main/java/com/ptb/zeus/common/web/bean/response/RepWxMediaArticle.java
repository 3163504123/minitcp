package com.ptb.zeus.common.web.bean.response;

/**
 * 微信媒体文章列表
 * @author lenovo
 *
 */
public class RepWxMediaArticle {
	
	private long pubTime;
	private String title;
	private String coverPlan;
	private int  readNum;
	private int zanNum;
	private String url;
	private String pMid;
	private String mediaName;
	private String brief;
	private int isAuth;
	private String authInfo;

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}


	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
	}

	public int getIsAuth() {
		return isAuth;
	}

	public String getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
	}

	public long getPubTime() {
		return pubTime;
	}
	public void setPubTime(long pubTime) {
		this.pubTime = pubTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverPlan() {
		return coverPlan;
	}
	public void setCoverPlan(String coverPlan) {
		this.coverPlan = coverPlan;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public int getZanNum() {
		return zanNum;
	}
	public void setZanNum(int zanNum) {
		this.zanNum = zanNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getpMid() {
		return pMid;
	}
	public void setpMid(String pMid) {
		this.pMid = pMid;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	
	
	

}
