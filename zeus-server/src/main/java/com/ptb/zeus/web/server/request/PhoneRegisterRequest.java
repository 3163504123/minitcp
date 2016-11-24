package com.ptb.zeus.web.server.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by eric on 2016/10/22.
 */
public class PhoneRegisterRequest {

	@Pattern(regexp = "^1[3-9]{1}\\d{9}$", message =   "手机号格式不正确")
	String p;

	@Size(max = 25,min=6,message = "密码长度应为6-25位")
	String w;

	@Size(min = 6,max = 6,message = "验证码为6位数字字母")
	String v;

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getW() {
		return w;
	}

	public void setW(String w) {
		this.w = w;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}
}
