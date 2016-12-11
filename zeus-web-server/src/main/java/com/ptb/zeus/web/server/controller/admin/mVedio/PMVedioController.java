package com.ptb.zeus.web.server.controller.admin.mVedio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("admin/video")
public class PMVedioController {
	@RequestMapping("")
	public String userPage(Map<String, Object> model) {
		return "/admin/video/main";
	}

	@RequestMapping("/edit")
	public String editUserPage(Map<String, Object>model) {
		return "/admin/video/edit";
	}
}

