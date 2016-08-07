package com.ptb.zeus.common.common;
/**
 * 微博媒体热文
 * @author lenovo
 *
 */
public class WbMediaHotArticleBean {
	public static WbMediaHotArticleBean Default=new WbMediaHotArticleBean();


	private String url;
	private String title;
	private String coverPlan;
	private String mediaName;
	private int spreadNum;
	private int commentNum;
	private int zanNum;
	private int isOriginal;
	private String pMid;
	private long pubTime;
	private int isAuth;
	private String mediaImg;

	public String getMediaImg() {
		return mediaImg;
	}
	public void setMediaImg(String mediaImg) {
		this.mediaImg = mediaImg;
	}
	public String getMediaName() {
		return mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCoverPlan() {
		return coverPlan;
	}
	public void setCoverPlan(String coverPlan) {
		this.coverPlan = coverPlan;
	}
	public long getPubTime() {
		return pubTime;
	}
	public void setPubTime(long pubTime) {
		this.pubTime = pubTime;
	}
	public int getSpreadNum() {
		return spreadNum;
	}
	public void setSpreadNum(int spreadNum) {
		this.spreadNum = spreadNum;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getZanNum() {
		return zanNum;
	}
	public void setZanNum(int zanNum) {
		this.zanNum = zanNum;
	}
	public int getIsOriginal() {
		return isOriginal;
	}
	public void setIsOriginal(int isOriginal) {
		this.isOriginal = isOriginal;
	}
	public String getpMid() {
		return pMid;
	}
	public void setpMid(String pMid) {
		this.pMid = pMid;
	}
	public int getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
	}


	public static WbMediaHotArticleBean getDefault() {
		return Default;
	}
	public static void setDefault(WbMediaHotArticleBean default1) {
		Default = default1;
	}
}
