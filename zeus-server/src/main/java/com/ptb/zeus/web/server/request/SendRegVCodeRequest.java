package com.ptb.zeus.web.server.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/12
 * @version 1.0.0
 * @description 类的功能
 */
public class SendRegVCodeRequest {
	@Pattern(regexp = "^1[3-9]{1}\\d{9}$", message =   "手机号格式不正确")
	String phone;


	@Size(min = 4,max = 4,message = "图片验证码不正确")
	String imageVcode;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageVcode() {
		return imageVcode;
	}

	public void setImageVcode(String imageVcode) {
		this.imageVcode = imageVcode;
	}
}
