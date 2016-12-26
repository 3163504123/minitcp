package com.ptb.zeus.web.backend.controller.mPay;

import com.ptb.zeus.common.core.model.main.MAccountUser;
import com.ptb.zeus.common.core.model.user.TbUser;
import com.ptb.zeus.service.main.IMAccountUserService;
import com.ptb.zeus.service.user.ITbUserService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.basic.request.BackendRechargeRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/24
 * @version 1.0.0
 * @description 类的功能
 */
@RestController
@RequestMapping("/admin/pay")
public class APayController extends BaseRestController{
	private static Logger logger = LoggerFactory.getLogger(APayController.class);

	@Autowired
	IMAccountUserService imAccountUserService;
	@Autowired
	ITbUserService iTbUserService;

	@RequestMapping("recharge")
	public Object recharge(@Valid  BackendRechargeRequest request, BindingResult br) {
		List<TbUser> users = iTbUserService.getUserByIdentiy(request.getPhone());
		if(users.size() > 0) {
			MAccountUser acct = imAccountUserService.getAccountByUserID(users.get(0).getId());
			imAccountUserService.recharge(acct,request.getPoint(),request.getSource(),request.getDesc());
		}
		return BaseResponse.NormalResponse;
	}
}
