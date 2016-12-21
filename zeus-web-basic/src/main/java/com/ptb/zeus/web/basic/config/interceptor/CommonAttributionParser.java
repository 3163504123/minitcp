package com.ptb.zeus.web.basic.config.interceptor;

import com.ptb.zeus.common.core.utils.security.security.TokenUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/17
 * @version 1.0.0
 * @description 类的功能
 */
public class CommonAttributionParser {
	private static Logger logger = LoggerFactory.getLogger(CommonAttributionParser.class);

	private static void parse(HttpServletRequest request) {
		parseTokenFromRequest(request);
	}

	public static void parseTokenFromRequest(HttpServletRequest request) {
		if(request.getAttribute("token") == null) {
			String uuid = request.getHeader("uuid");
			if (uuid == null) {
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("uuid")) {
							uuid = cookie.getValue();
							break;
						}
					}
				}
			}

			//将用户TOKEN解析到上下文中，方便使用
			if (uuid != null) {
				try {
					request.setAttribute("token", TokenUtils.decode(uuid));
				}catch (Exception e) {
					logger.warn(String.format("无效的TOKEN %s", uuid));
				}
			}
		}
	}
}
