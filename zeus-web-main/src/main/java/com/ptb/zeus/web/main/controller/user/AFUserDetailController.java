package com.ptb.zeus.web.main.controller.user;

import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.main.IMAccountUserService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.response.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 用户注册，登陆，找回密码，相关的API
 */
@Controller
@RequestMapping("/api/u")
@PreAuthorize(value = "!isAnonymous()")
public class AFUserDetailController extends BaseRestController {
	static Logger logger = LoggerFactory.getLogger(AFUserDetailController.class);

	@Autowired
	ITbUserService iTbUserService;
	@Autowired
	IMAccountUserService imAccountUserService;

	@RequestMapping("basicInfo")
	@ResponseBody
	public BaseResponse baseInfo() {
		TbUser tbUser = iTbUserService.selectById(getToken().getUid());
		tbUser.setPassword("");
		return new BaseResponse(tbUser);
	}

/*	@RequestMapping("acctInfo")
	@ResponseBody
	public BaseResponse acctInfo() {
		imAccountUserService.getAccountByUserID(getToken().getUid());
		return new BaseResponse(tbUser);
	}*/




}
