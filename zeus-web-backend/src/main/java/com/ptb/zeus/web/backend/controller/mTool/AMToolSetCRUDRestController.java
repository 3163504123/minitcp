package com.ptb.zeus.web.backend.controller.mTool;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MToolSet;
import com.ptb.zeus.service.main.IMToolSetService;
import com.ptb.zeus.web.basic.controller.BaseRestCRUDRestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/admin/api/toolSet")
public class AMToolSetCRUDRestController extends BaseRestCRUDRestController<MToolSet,Long> {
	@Resource
	IMToolSetService imToolSetService;


	@Override
	protected ISuperService<MToolSet> getBasicService() {
		return imToolSetService;
	}
}
