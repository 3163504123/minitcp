package com.ptb.zeus.web.server.controller.mTool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/tool")
public class PMToolController {
	@RequestMapping("")
	public String userPage(Map<String, Object> model) {
		return "tool/main";
	}

	@RequestMapping("/edit")
	public String editUserPage(Map<String, Object>model) {
		return "tool/edit";
	}
}

