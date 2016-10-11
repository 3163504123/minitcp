package com.ptb.zeus.web.server.controller;

import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.server.service.CacheService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("api/user")
@Controller
public class UserController {
	@Resource(name = "myAuthenticationManagerBean")
	AuthenticationManager authenticationManager;

	@Resource
	ITbUserService iTbUserService;

	@Autowired
	CacheService cacheService;

	@RequestMapping("login")
	@ResponseBody
	public String login(SecurityContextHolderAwareRequestWrapper request) {
		try {
			if(SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
				request.login("1", "3163504123");
			}else{
				return String.format("已登陆的用户");
			}
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return String.format("登陆成功");
	}

	@RequestMapping("logout")
	@ResponseBody
	public String logout(SecurityContextHolderAwareRequestWrapper request) {
		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return String.format("logout");
	}

	@RequestMapping("echo1")
	@ResponseBody
	public String test1(HttpServletRequest request)
	{
		return cacheService.echo();
	}









}
