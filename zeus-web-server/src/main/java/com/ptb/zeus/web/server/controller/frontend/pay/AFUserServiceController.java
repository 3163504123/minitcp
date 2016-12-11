package com.ptb.zeus.web.server.controller.frontend.pay;

import com.ptb.zeus.service.main.IMUserServiceService;
import com.ptb.zeus.web.controller.BaseRestController;
import com.ptb.zeus.web.server.request.BuyServiceRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;

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

	public String buyProductService(@CookieValue(name = "E_SESSION_USERID",required = false) String uid,
	                                BuyServiceRequest request) {
		imUserServiceService.buyProductService(Integer.valueOf(uid),request.getProductID());
		return null;
	}
}
