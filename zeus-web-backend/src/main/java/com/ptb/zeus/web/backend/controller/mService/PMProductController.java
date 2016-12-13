package com.ptb.zeus.web.backend.controller.mService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("admin/product")
class PMProductController {
	@RequestMapping("")
	public String userPage(Map<String, Object> model) {
		return "/admin/product/main";
	}

	@RequestMapping("/edit")
	public String editUserPage(Map<String, Object>model) {
		return "/admin/product/edit";
	}
}

