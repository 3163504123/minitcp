package com.ptb.zeus.web.basic.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.ptb.zeus.web.utils.SessionConstant.KEY_UUID;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/1
 * @version 1.0.0
 * @description 解析出TOKEN和BASEPATH 路径到上下文
 */
public class UUIDAndContextIocInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse httpServletResponse,
			Object o) throws Exception {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int port = request.getServerPort();
		String path = request.getContextPath();
		String basePath = scheme + "://" + serverName + ":" + port + path;

		//设置页面的基本路径
		request.setAttribute("basePath", basePath);
		request.setAttribute("fullPath",basePath+request.getServletPath());
		request.setAttribute("contextPath",request.getContextPath());

		CommonAttributionParser.parseTokenFromRequest(request);
		if(request.getAttribute("token") == null) {
			Cookie cookie = new Cookie(KEY_UUID, null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			httpServletResponse.addCookie(cookie);
		}
		return true;
	}


	@Override
	public void postHandle(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}
