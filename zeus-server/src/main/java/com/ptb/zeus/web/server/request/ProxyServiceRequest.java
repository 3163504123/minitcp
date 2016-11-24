package com.ptb.zeus.web.server.request;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/24
 * @version 1.0.0
 * @description 类的功能
 */
public class ProxyServiceRequest {
	String key;  //服务的ID号
	int size;          //请求代理数量


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
