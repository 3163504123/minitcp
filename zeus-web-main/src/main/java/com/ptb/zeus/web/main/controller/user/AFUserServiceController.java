package com.ptb.zeus.web.main.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MAccountUserStatement;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMUserServiceService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.basic.request.PageRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

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
public class AFUserServiceController extends BaseRestController{
	static Logger logger = LoggerFactory.getLogger(AFUserServiceController.class);

	@Resource
	ITbUserService iTbUserService;

	@Resource
	IMUserServiceService imUserServiceService;


	@RequestMapping("list")
	@ResponseBody
	public Object getEntitys(PageRequest request, MUserService mUserService,
	                         @RequestParam(name = "f", defaultValue = "0") int f) {

		if(mUserService == null || mUserService.getUid() == null || getToken().getUid() !=  mUserService.getUid()) {
			throw UserException.InvaildUIDRequest;
		}

		Page<MUserService> page = new Page<MUserService>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());

		Page<MAccountUserStatement> tbUserPage = imUserServiceService.selectPage(page, new EntityWrapper(mUserService));

		HashMap<Object, Object> map = new HashMap<>();
		map.put("rows",tbUserPage.getRecords());
		map.put("total",tbUserPage.getTotal());
		if(f == 1) {
			return new BaseResponse<>(map);
		}
		return map;
	}


}
