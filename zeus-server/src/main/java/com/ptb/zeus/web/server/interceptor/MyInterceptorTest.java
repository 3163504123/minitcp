package com.ptb.zeus.web.server.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/1
 * @version 1.0.0
 * @description 类的功能
 */
public class MyInterceptorTest implements HandlerInterceptor {
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse httpServletResponse,
			Object o) throws Exception {
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int port = request.getServerPort();
		String path = request.getContextPath();
		String basePath = scheme + "://" + serverName + ":" + port + path;
		request.setAttribute("basePath", basePath);
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
/*		System.out.println(3);*/
	}
}
