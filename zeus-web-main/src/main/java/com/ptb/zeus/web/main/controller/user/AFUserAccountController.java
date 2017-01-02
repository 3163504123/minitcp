package com.ptb.zeus.web.main.controller.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.main.MAccountUserStatement;
import com.ptb.zeus.exception.UserException;
import com.ptb.zeus.service.main.IMAccountUserService;
import com.ptb.zeus.service.main.IMAccountUserStatementService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.basic.request.PageRequest;
import com.ptb.zeus.web.basic.response.PageableResponse;
import com.ptb.zeus.web.main.request.StatementRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 用户注册，登陆，找回密码，相关的API
 */
@Controller
@RequestMapping("/api/u/acct")
@PreAuthorize(value = "!isAnonymous()")
public class AFUserAccountController extends BaseRestController {
	static Logger logger = LoggerFactory.getLogger(AFUserAccountController.class);

	@Autowired
	ITbUserService iTbUserService;
	@Autowired
	IMAccountUserService imAccountUserService;
	@Autowired
	IMAccountUserStatementService imAccountUserStatementService;


	@RequestMapping("info")
	@ResponseBody
	public BaseResponse userAccount() {
		MAccountUser acctInfo = imAccountUserService.getAccountByUserID(getToken().getUid());
		return new BaseResponse(acctInfo);
	}


	@RequestMapping("statement")
	@ResponseBody
	public Object getEntitys(PageRequest request, StatementRequest statementRequest, @RequestParam(name = "f", defaultValue = "1") int f) {

		Page<MAccountUserStatement> page = new Page<MAccountUserStatement>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());

		MAccountUser acct = imAccountUserService.getAccountByUserID(getToken().getUid());
		if(acct == null) {
			throw UserException.NoExistUserError;
		}

		Page<MAccountUserStatement> tbUserPage  = imAccountUserStatementService.selectPage(page,acct,new Date(statementRequest.getStartDate()),
		                                                                                   new Date(statementRequest.getStopDate()));


		if(f == 1) {
			return 	new BaseResponse<>(new PageableResponse(tbUserPage.getTotal(), tbUserPage.getRecords()));
		}
		return new PageableResponse(tbUserPage.getTotal(), tbUserPage.getRecords());
	}
}
