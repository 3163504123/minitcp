package com.ptb.zeus.web.main.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/30
 * @version 1.0.0
 * @description 类的功能
 */
public class CreateOrderRequest {
	/*商品ID*/
	@NotBlank
	Integer productID ;
	/*商品数量*/
	Integer num = 1;


	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}
}
