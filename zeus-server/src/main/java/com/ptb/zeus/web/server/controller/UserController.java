package com.ptb.zeus.web.server.controller;

import com.ptb.zeus.service.user.ITbUserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Resource
	ITbUserService iTbUserService;

	@RequestMapping("echo")
	@ResponseBody
	public String test(HttpServletRequest request) {
		int i = iTbUserService.selectCount(null);
		return String.format("%d",i);
		//request.getSession().setAttribute("test","test");
		//Object test = request.getSession().getAttribute("test");
		//return userService.echo() + test;
	}

}
