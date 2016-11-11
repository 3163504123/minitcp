package com.ptb.zeus.web.server.controller.mTool;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.service.main.IMToolService;
import com.ptb.zeus.web.server.controller.BaseRestCRUDController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/api/tool")
public class AMToolCRUDController extends BaseRestCRUDController<MTool> {
	@Resource
	IMToolService imToolService;

	@Override
	protected ISuperService<MTool> getBasicService() {
		return imToolService;
	}
}
