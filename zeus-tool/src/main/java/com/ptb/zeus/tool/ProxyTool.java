package com.ptb.zeus.tool;

import com.ptb.zeus.service.main.IMProxyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/31
 * @version 1.0.0
 * @description 类的功能
 */
public class ProxyTool {
	private static Logger logger = LoggerFactory.getLogger(ProxyTool.class);

	public static void newProxy(IMProxyService service) {
		service.getNews();
	}

	public static void checkProxy(IMProxyService service) {
		service.checkPooledProxy(5,false);

	}
}
