package com.ptb.zeus.web.server.controller.mMain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by eric on 16/10/9.
 */
@Controller
public class PMainController {
	@RequestMapping("/admin")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "hello");
		return "/admin/common/mainPanel";
	}
}
