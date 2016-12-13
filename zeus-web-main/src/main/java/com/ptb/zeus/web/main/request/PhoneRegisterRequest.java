package com.ptb.zeus.web.main.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by eric on 2016/10/22.
 */
public class PhoneRegisterRequest {

	@Pattern(regexp = "^1[3-9]{1}\\d{9}$", message = "手机号格式不正确")
	String ph;

	@Size(max = 25, min = 6, message = "密码长度应为6-25位")
	String pw;

	@Size(min = 6, max = 6, message = "验证码为6位数字字母")
	String vcode;

	@Size(min = 6, max = 20, message = "用户名应为6到20位")
	@Pattern(regexp = "\\w{6,20}", message = "用户名不合法，请用字母数字小划线定义用户名")
	String un;

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
}
