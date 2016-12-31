package com.ptb.zeus.web.main.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/24
 * @version 1.0.0
 * @description 类的功能
 */
public class IdentifyVCodeServiceRequest {
	@NotBlank
	String key;  //服务的ID号

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
