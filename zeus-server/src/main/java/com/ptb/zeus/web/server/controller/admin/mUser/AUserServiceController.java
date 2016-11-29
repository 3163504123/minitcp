package com.ptb.zeus.web.server.controller.admin.mUser;

import com.baomidou.framework.service.ISuperService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.service.main.IMUserServiceService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.server.controller.admin.mBase.BaseRestCRUDRestController;
import com.ptb.zeus.web.server.request.PageRequest;
import com.ptb.zeus.web.utils.SessionConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 类的功能
 */
@Controller
@RequestMapping("admin/api/service/")
public class AUserServiceController extends BaseRestCRUDRestController<Integer,MUserService> {

	@Autowired
	IMUserServiceService imUserServiceService;

	@Autowired
	ITbUserService tbUserService;


	@RequestMapping("/u/list")
	public Object getUserServices(PageRequest request, HttpSession httpSession) {
		Integer uid = (Integer) httpSession.getAttribute(SessionConstant.E_SESSION_USERID.name());
		Page<MUserService> page = new Page<>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());
		MUserService mUserService = new MUserService();
		mUserService.setUid(uid);
		Page<MUserService> mUserServicePage = imUserServiceService.selectPage(page, new EntityWrapper<>(mUserService));
		return mUserServicePage.getRecords();
	}

	@Override
	protected ISuperService<MUserService> getBasicService() {
		return imUserServiceService;
	}



}
