package com.ptb.zeus.common.core.model.main;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2017/1/4
 * @version 1.0.0
 * @description 类的功能
 */
public class ReginizeHiistory {
	Long uid;  //用户ID
	String result;  //识别结果
	String imgUrl;  //识别源图片的URL地址
	String key;     //识别KEY
	int errorCode;
	String errorMessage;
	long ctime;     //创建时间


	public ReginizeHiistory() {
	}

	public ReginizeHiistory(Long uid, String result, String imgUrl, String key,String errorMessage,int errorCode) {
		this.uid = uid;
		this.result = result;
		this.imgUrl = imgUrl;
		this.key = key;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}
}
