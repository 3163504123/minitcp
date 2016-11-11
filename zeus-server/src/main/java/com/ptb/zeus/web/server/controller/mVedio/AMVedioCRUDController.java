package com.ptb.zeus.web.server.controller.mVedio;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MVedio;
import com.ptb.zeus.service.main.IMVedioService;
import com.ptb.zeus.web.server.controller.BaseRestCRUDController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("/api/video")
public class AMVedioCRUDController extends BaseRestCRUDController<MVedio> {
	@Resource
	IMVedioService imVedioService;

	@Override
	protected ISuperService<MVedio> getBasicService() {
		return imVedioService;
	}
}
