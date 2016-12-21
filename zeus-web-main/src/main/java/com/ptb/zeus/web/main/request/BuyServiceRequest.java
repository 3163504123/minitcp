package com.ptb.zeus.web.main.request;

import javax.validation.constraints.Size;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/11
 * @version 1.0.0
 * @description 类的功能
 */
public class BuyServiceRequest {
	@Size(min = 9)
	Long productID;


	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}
}
