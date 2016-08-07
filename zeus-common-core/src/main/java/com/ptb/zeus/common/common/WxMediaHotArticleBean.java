package com.ptb.zeus.common.common;
/**
 * 微信媒体热文
 * @author lenovo
 *
 */
public class WxMediaHotArticleBean {
	private String pMid;
	private String url;
	private String title;
	private String coverPlan;
	private String mediaName;
	private int zanNum;
	private int readNum;
	private int isOriginal;
	private int isAuth;
	private long pubTime;
	private String mediaImg;
	private String brief;

	public String getMediaImg() {
		return mediaImg;
	}
	public void setMediaImg(String mediaImg) {
		this.mediaImg = mediaImg;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	public String getpMid() {
		return pMid;
	}
	public void setpMid(String pMid) {
		this.pMid = pMid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getPubTime() {
		return pubTime;
	}
	public void setPubTime(long pubTime) {
		this.pubTime = pubTime;
	}
	public String getCoverPlan() {
		return coverPlan;
	}
	public void setCoverPlan(String coverPlan) {
		this.coverPlan = coverPlan;
	}
	public int getZanNum() {
		return zanNum;
	}
	public void setZanNum(int zanNum) {
		this.zanNum = zanNum;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public int getIsOriginal() {
		return isOriginal;
	}
	public void setIsOriginal(int isOriginal) {
		this.isOriginal = isOriginal;
	}
	public int getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
	}
}
