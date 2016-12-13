package com.ptb.zeus.web.basic.interceptor;

import com.ptb.zeus.common.core.utils.security.security.TokenUtils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/1
 * @version 1.0.0
 * @description 解析出TOKEN和PATH 路径到上下文
 */
public class UUIDInterceptorTest implements HandlerInterceptor {
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

		//将用户TOKEN解析到上下文中，方便使用
		if (request.getHeader("uuid") != null) {
			request.setAttribute("token", TokenUtils.decode(request.getHeader("uuid")));
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
/*		System.out.println(3);*/
	}
}
