package com.ptb.zeus.common.core.utils.business;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/2
 * @version 1.0.0
 * @description 类的功能
 */
public class ProductUtil {
	/*编码含义 前三位带表父类，中三位代表子类，后三表代码服务类型*/
	final static int CODE_PROXY_GOOD = 1001001;
	final static int CODE_PROXY_PERFECT = 1001002;
	final static int CODE_PROXY_DYNAMIC = 1001003;

	final static int CODE_PRODUCT_TYPE_DAY = 1;
	final static int CODE_PRODCUT_TYPE_WEEK = 2;
	final static int CODE_PRODUCT_TYPE_MOUNTH = 3;
	final static int CODE_PRODUCT_TYPE_QUARTER= 4;
	final static int CODE_PRODUCT_TYPE_YEAR = 5;

	public static boolean isGoodProxy(int code) {
		return CODE_PROXY_GOOD == (code / 100);
	}

	public static boolean isPerfectProxy(int code) {
		return CODE_PROXY_PERFECT == (code / 100);
	}

	public static boolean isDyNamicProxy(int code) {
		return CODE_PROXY_DYNAMIC == (code / 100);
	}
}
