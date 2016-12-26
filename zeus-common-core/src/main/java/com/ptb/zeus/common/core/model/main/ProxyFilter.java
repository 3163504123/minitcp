package com.ptb.zeus.common.core.model.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/24
 * @version 1.0.0
 * @description 类的功能
 */
public class ProxyFilter {
	private static Logger logger = LoggerFactory.getLogger(ProxyFilter.class);
	List<String> anonymity;
	List<String> type;
	List<Integer> port;
	String country;


	public List<String> getAnonymity() {
		return anonymity;
	}

	public void setAnonymity(List<String> anonymity) {
		this.anonymity = anonymity;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public List<Integer> getPort() {
		return port;
	}

	public void setPort(List<Integer> port) {
		this.port = port;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
