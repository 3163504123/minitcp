package com.ptb.zeus.web.main.controller.user;

import com.baomidou.framework.service.IService;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.service.main.IMUserServiceService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.basic.controller.ListRestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 用户注册，登陆，找回密码，相关的API
 */
@Controller
@RequestMapping("/api/u/svc")
@PreAuthorize(value = "!isAnonymous()")
public class AFUserServiceController extends ListRestController<MUserService,Long> {
	static Logger logger = LoggerFactory.getLogger(AFUserServiceController.class);

	@Resource
	ITbUserService iTbUserService;

	@Resource
	IMUserServiceService imUserServiceService;

	@Override
	protected IService<MUserService, Long> getBasicService() {
		return imUserServiceService;
	}
}
