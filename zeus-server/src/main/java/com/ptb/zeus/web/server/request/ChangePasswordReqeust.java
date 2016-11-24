package com.ptb.zeus.web.server.request;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/12
 * @version 1.0.0
 * @description 类的功能
 */
public class ChangePasswordReqeust {
	String ph;
	String phoneCode;
	String imgCode;
	String npass;


	public String getP() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getNpass() {
		return npass;
	}

	public void setNpass(String npass) {
		this.npass = npass;
	}
}
