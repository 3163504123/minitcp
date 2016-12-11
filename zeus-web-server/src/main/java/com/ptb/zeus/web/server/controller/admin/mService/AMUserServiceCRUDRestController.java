package com.ptb.zeus.web.server.controller.admin.mService;

import com.baomidou.framework.service.ISuperService;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.service.main.IMUserServiceService;
import com.ptb.zeus.web.server.controller.admin.mBase.BaseRestCRUDRestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by eric on 16/10/9.
 */
@Controller
@RequestMapping("admin/api/userService")
public class AMUserServiceCRUDRestController extends BaseRestCRUDRestController<Integer,MUserService> {
	@Resource
	IMUserServiceService imUserServiceService;

	@Override
	protected ISuperService<MUserService> getBasicService() {
		return imUserServiceService;
	}
}
