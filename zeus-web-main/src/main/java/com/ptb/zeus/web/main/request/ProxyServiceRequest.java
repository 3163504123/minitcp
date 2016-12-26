package com.ptb.zeus.web.main.request;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/24
 * @version 1.0.0
 * @description 类的功能
 */
public class ProxyServiceRequest {
	@NotBlank
	String key;  //服务的ID号

	@Min(0)
	@Max(100)
	int size = 1;          //请求代理数量


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
