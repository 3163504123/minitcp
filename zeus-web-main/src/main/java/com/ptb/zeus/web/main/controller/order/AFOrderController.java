package com.ptb.zeus.web.main.controller.order;

import com.baomidou.mybatisplus.plugins.Page;
import com.ptb.zeus.common.core.model.main.MOrder;
import com.ptb.zeus.service.main.IMAccountUserService;
import com.ptb.zeus.service.main.IMOrderService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.basic.request.PageRequest;
import com.ptb.zeus.web.basic.response.PageableResponse;
import com.ptb.zeus.web.main.request.CreateOrderRequest;
import com.ptb.zeus.web.main.request.StatementRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.validation.Valid;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 订单和购买相关的API
 */
@RestController
@RequestMapping("/api/u/order")
@PreAuthorize(value = "!isAnonymous()")
public class AFOrderController extends BaseRestController{
	static Logger logger = LoggerFactory.getLogger(AFOrderController.class);

	@Autowired
	IMOrderService imOrderService;
	@Autowired
	IMAccountUserService accountUserService;

	@RequestMapping("create")
	@PreAuthorize(value = "!isAnonymous()")
	public Object createOrder(@Valid  CreateOrderRequest createOrderRequest, BindingResult bindingResult) {
		checkParams(bindingResult);


		String orderID = imOrderService.createOrder(getToken().getUid(),createOrderRequest.getProductID(),createOrderRequest.getNum());

		return new BaseResponse<>(orderID);
	}

	@PreAuthorize(value = "!isAnonymous()")
	@RequestMapping("complete")
	public Object completeOrder(String orderID) {
		imOrderService.completeOrder(orderID,getToken().getUid());
		return BaseResponse.NormalResponse;
	}


	@RequestMapping("cancel")
	public Object cancelOrder(@Valid  @NotBlank  String orderID,BindingResult bindingResult) {
		imOrderService.cancelOrder(getToken().getUid(),orderID);
		return null;
	}


	@RequestMapping("list")
	@ResponseBody
	public Object getEntitys(PageRequest request, StatementRequest statementRequest, @RequestParam(name = "f", defaultValue = "1") int f) {

		Page<MOrder> page = new Page<MOrder>(request.getPage(), request.getRows(), request.getSort());
		page.setAsc(request.isAsc());

		Page<MOrder> tbUserPage  = imOrderService.selectPage(page,getToken().getUid(),new Date(statementRequest.getStartDate()),
		                                                                                   new Date(statementRequest.getStopDate()));

		if(f == 1) {
			return 	new BaseResponse<>(new PageableResponse(tbUserPage.getTotal(), tbUserPage.getRecords()));
		}
		return new PageableResponse(tbUserPage.getTotal(), tbUserPage.getRecords());
	}

}
