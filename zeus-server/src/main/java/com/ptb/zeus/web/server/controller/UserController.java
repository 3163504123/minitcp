package com.ptb.zeus.web.server.controller;

import com.ptb.zeus.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by eric on 16/8/19.
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("echo")
	@ResponseBody
	public String test() {
		return userService.echo();

	}
}
