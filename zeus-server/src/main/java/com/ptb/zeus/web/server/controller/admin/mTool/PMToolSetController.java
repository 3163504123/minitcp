package com.ptb.zeus.web.server.controller.admin.mTool;

import com.ptb.zeus.common.core.mapper.user.TbUserMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/admin/toolSet")
public class PMToolSetController {
	@Resource
	TbUserMapper tbUserMapper;
	@RequestMapping("")
	public String userPage(Map<String, Object> model) {
		return "/admin/toolSet/main";
	}

	@RequestMapping("/edit")
	public String editUserPage(Map<String, Object>model) {
		return "/admin/toolSet/edit";
	}

}

