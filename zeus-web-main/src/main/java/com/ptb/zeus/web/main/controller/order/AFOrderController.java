package com.ptb.zeus.web.main.controller.order;

import com.baomidou.framework.service.IService;
import com.ptb.zeus.common.core.model.main.MOrder;
import com.ptb.zeus.service.main.IMAccountUserService;
import com.ptb.zeus.service.main.IMOrderService;
import com.ptb.zeus.web.basic.controller.ListRestController;
import com.ptb.zeus.web.main.request.CreateOrderRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 订单和购买相关的API
 */
@Controller
@RequestMapping("/api/u/order")
@PreAuthorize(value = "!isAnonymous()")
public class AFOrderController extends ListRestController<MOrder,String>{
	static Logger logger = LoggerFactory.getLogger(AFOrderController.class);

	@Autowired
	IMOrderService imOrderService;
	@Autowired
	IMAccountUserService accountUserService;

	@RequestMapping("create")
	public Object createOrder(@Valid  CreateOrderRequest createOrderRequest, BindingResult bindingResult) {
		checkParams(bindingResult);


		String orderID = imOrderService.createOrder(getToken().getUid(),createOrderRequest.getProductID(),createOrderRequest.getNum());

		return new BaseResponse<>(orderID);
	}

	@RequestMapping("complete")
	public Object completeOrder(@Valid  @NotBlank  String orderID,BindingResult bindingResult) {
		checkParams(bindingResult);
		imOrderService.completeOrder(orderID,getToken().getUid());
		return BaseResponse.NormalResponse;
	}


	@RequestMapping("cancel")
	public Object cancelOrder(@Valid  @NotBlank  String orderID,BindingResult bindingResult) {
		imOrderService.cancelOrder(getToken().getUid(),orderID);
		return null;
	}

	@Override
	protected IService<MOrder, String> getBasicService() {
		return imOrderService;
	}
}
