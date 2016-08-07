package com.ptb.zeus.common.common;


/**
 * 微博搜索
 * @author lenovo
 *
 */
public class WbMediaInfo extends MediaInfo {
	private String mediaId;
	private int collection;
	private String mediaImage;
	private String mediaName;
	private int isAuth;
	private String authInfo;
	private int fansNum;
	private String pMid;
	private int type;
	private String brief;
	private long addTime;
	private int isOriginal;
	private int collectedUserCount;


	public int getCollectedUserCount() {
		return collectedUserCount;
	}

	public void setCollectedUserCount(int collectedUserCount) {
		this.collectedUserCount = collectedUserCount;
	}

	public int getIsOriginal() {
		return isOriginal;
	}


	public void setIsOriginal(int isOriginal) {
		this.isOriginal = isOriginal;
	}

	public long getAddTime() {
		return addTime;
	}

	public void setAddTime(long addTime) {
		this.addTime = addTime;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public int getCollection() {
		return collection;
	}

	public void setCollection(int collection) {
		this.collection = collection;
	}

	public String getMediaImage() {
		return mediaImage;
	}

	public void setMediaImage(String mediaImage) {
		this.mediaImage = mediaImage;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public int getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
	}

	public String getAuthInfo() {
		return authInfo;
	}

	public void setAuthInfo(String authInfo) {
		this.authInfo = authInfo;
	}

	public int getFansNum() {
		return fansNum;
	}

	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
	}

	public String getpMid() {
		return pMid;
	}

	public void setpMid(String pMid) {
		this.pMid = pMid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
