package com.ptb.zeus.web.server.controller.mVedio;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MVedioSet;
import com.ptb.zeus.service.main.IMVedioSetService;
import com.ptb.zeus.web.server.controller.BaseRestCRUDController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/api/videoSet")
public class AMVedioSetCRUDController extends BaseRestCRUDController<MVedioSet> {
	@Resource
	IMVedioSetService imVedioSetService;


	@Override
	protected ISuperService<MVedioSet> getBasicService() {
		return imVedioSetService;
	}
}