package com.ptb.zeus.common.common;
/**
 * 微博热媒体
 * @author lenovo
 *
 */
public class WbHotMedia {
	private String pMid;
	private String mediaName;
	private int    type;
	private String mediaImage;
	private int isAuth;
	private int num;
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

	public String getMediaImage() {
		return mediaImage;
	}
	public void setMediaImage(String mediaImage) {
		this.mediaImage = mediaImage;
	}
	public int getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(int isAuth) {
		this.isAuth = isAuth;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
