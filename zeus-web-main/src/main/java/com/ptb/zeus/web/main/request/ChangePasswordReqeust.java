package com.ptb.zeus.web.main.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/12
 * @version 1.0.0
 * @description 类的功能
 */
public class ChangePasswordReqeust {
	@Pattern(regexp = "\\d{11}",message = "手机号格式不正确")
	String ph;
	@NotBlank
	String v;
	@NotBlank
	String ps;

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}
	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}
}
