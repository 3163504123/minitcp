package com.ptb.zeus.web.server.controller.admin.mVedio;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MVedio;
import com.ptb.zeus.service.main.IMVedioService;
import com.ptb.zeus.web.server.controller.admin.mBase.BaseRestCRUDRestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("admin/api/video")
public class AMVedioCRUDRestController extends BaseRestCRUDRestController<Integer,MVedio> {
	@Resource
	IMVedioService imVedioService;

	@Override
	protected ISuperService<MVedio> getBasicService() {
		return imVedioService;
	}
}
