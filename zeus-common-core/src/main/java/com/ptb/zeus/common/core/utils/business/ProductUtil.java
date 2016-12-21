package com.ptb.zeus.common.core.utils.business;

import java.util.concurrent.TimeUnit;

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
	final static int CODE_PROXY_FREE=1001000;
	final static int CODE_PROXY_DYNAMIC = 1001003;

	final static int CODE_PRODUCT_TYPE_DAY = 1;
	final static int CODE_PRODCUT_TYPE_WEEK = 2;
	final static int CODE_PRODUCT_TYPE_MOUNTH = 3;
	final static int CODE_PRODUCT_TYPE_QUARTER= 4;
	final static int CODE_PRODUCT_TYPE_YEAR = 5;

	public final static int CODE_PRODUCT_SERVICE_TYPE_TIME=0; //时间类型
	public final static int CODE_PRODUCT_SERVICE_TYPE_ENABLE=1; //使能类型

	public final static int CODE_PRODUCT_SERVICE_TYPE_PERCENT_COUNT=5; //百次类型
	public final static int CODE_PRODUCT_SERVICE_TYPE_THOUSAND_COUNT=6; //千次类型
	public final static int CODE_PRODUCT_SERVICE_TYPE_TEN_THOUSAND_COUNT=7; //万次类型

	public static boolean isFreeProxy(int code) {
		return CODE_PROXY_FREE == (code / 100);
	}

	public static boolean isGoodProxy(int code) {
		return CODE_PROXY_GOOD == (code / 100);
	}

	public static boolean isPerfectProxy(int code) {
		return CODE_PROXY_PERFECT == (code / 100);
	}

	public static boolean isDyNamicProxy(int code) {
		return CODE_PROXY_DYNAMIC == (code / 100);
	}

	public static int getProductType(int code) {
		return code / 100;
	}

	private static int getTimeUnit(int code) {
		return code % 10;
	}

	private static int getServiceCountUnit(int code) {
		return code % 10;
	}

	public static int getServiceMethod(int code) {
		return (code/10) % 10;
	}

	public static boolean isTimeServiceProduct(int code) {
		return getServiceMethod(code) == CODE_PRODUCT_SERVICE_TYPE_TIME;
	}


	public static boolean isCountServiceProduct(int code) {
		return getServiceMethod(code) > 4;
	}

	public static long getTimeServiceSeconds(int code) {
		int timeUnit = getTimeUnit(code);
		switch (timeUnit) {
			case CODE_PRODUCT_TYPE_DAY:
				return TimeUnit.DAYS.toSeconds(1);
			case CODE_PRODCUT_TYPE_WEEK:
				return  TimeUnit.DAYS.toSeconds(1) * 7;
			case CODE_PRODUCT_TYPE_MOUNTH:
				return TimeUnit.DAYS.toSeconds(1) * 30;
			case CODE_PRODUCT_TYPE_QUARTER:
				return TimeUnit.DAYS.toSeconds(1) * 90;
			case CODE_PRODUCT_TYPE_YEAR:
				return TimeUnit.DAYS.toSeconds(1) * 360;
		}
		return 0;
	}

	/**
	 * Gets service count.
	 *
	 * @param code 产品代码
	 * @return the service count
	 */
	public static int getServiceCount(int code) {
		if(code < 5) {
			throw new RuntimeException("无效的产品编号");
		}
		return new Double(Math.pow(10,getServiceCountUnit(code)-2)).intValue();
	}
}
