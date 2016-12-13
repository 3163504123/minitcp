package com.ptb.zeus.web.backend.controller.mTool;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MTool;
import com.ptb.zeus.service.main.IMToolService;
import com.ptb.zeus.web.basic.controller.BaseRestCRUDRestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/admin/api/tool")
public class AMToolCRUDRestController extends BaseRestCRUDRestController<MTool,Long> {
	@Resource
	IMToolService imToolService;

	@Override
	protected ISuperService<MTool> getBasicService() {
		return imToolService;
	}
}
