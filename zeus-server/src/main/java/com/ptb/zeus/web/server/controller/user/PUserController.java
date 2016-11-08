package com.ptb.zeus.web.server.controller.user;

import com.ptb.zeus.common.core.mapper.user.TbUserMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
public class PUserController {
	@Resource
	TbUserMapper tbUserMapper;
	@RequestMapping("/u")
	public String userPage(Map<String, Object> model) {
		return "user/main";
	}

	@RequestMapping("/u/edit")
	public String editUserPage(Map<String, Object>model) {
		return "user/edit";
	}

}

