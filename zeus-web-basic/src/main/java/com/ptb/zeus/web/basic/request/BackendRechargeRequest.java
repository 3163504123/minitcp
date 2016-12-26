package com.ptb.zeus.web.basic.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/24
 * @version 1.0.0
 * @description 类的功能
 */
public class BackendRechargeRequest {
	@Min(100)
	@Max(1000000)
	Integer point;

	@NotBlank
	String phone;
	@NotBlank
	String source;

	@NotBlank
	String desc;


	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
