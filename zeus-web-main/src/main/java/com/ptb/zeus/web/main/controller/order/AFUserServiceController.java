package com.ptb.zeus.web.main.controller.order;

import com.ptb.zeus.service.main.IMUserServiceService;
import com.ptb.zeus.web.basic.controller.BaseRestController;
import com.ptb.zeus.web.main.request.BuyServiceRequest;
import com.ptb.zeus.web.response.BaseResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/11
 * @version 1.0.0
 * @description 类的功能
 */
@Controller
public class AFUserServiceController extends BaseRestController {
	private static Logger logger = LoggerFactory.getLogger(AFUserServiceController.class);

	@Autowired
	IMUserServiceService imUserServiceService;

	@RequestMapping("order/buyProduct")
	@ResponseBody
	public Object buyProductService(@CookieValue(name = "E_SESSION_USERID",required = false) String uid,
	                                BuyServiceRequest request) {
		//购买商品
		imUserServiceService.buyProductService(Integer.valueOf(uid),request.getProductID());
		return BaseResponse.NormalResponse;
	}
}
