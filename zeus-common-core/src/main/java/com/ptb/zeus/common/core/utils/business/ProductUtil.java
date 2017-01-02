package com.ptb.zeus.common.core.utils.business;

import com.ptb.zeus.common.core.model.main.MProduct;
import com.ptb.zeus.common.core.model.main.MUserService;

import java.util.concurrent.TimeUnit;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/2
 * @version 1.0.0
 * @description 类的功能
 */
public class ProductUtil {
	/*########################################################################################*/
	/*编码含义 前三位带表父类，中三位代表子类，后三表代码服务类型*/
	public final static int CODE_PROXY_FREE = 1001000;
	public final static int CODE_PROXY_GOOD = 1001001;
	public final static int CODE_PROXY_PERFECT = 1001002;
	public final static int CODE_PROXY_DYNAMIC = 1001003;
	public final static int CODE_VCODE_GENERAL = 1003001;   //字符验证码识别

	/*判断服务内容。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。*/
	public static int getProductContent(int code) {
		return code / 100;
	}

	/*是否是免费代理*/
	public static boolean isFreeProxy(int code) {
		return CODE_PROXY_FREE == getProductContent(code);
	}

	/*是否是优质代理*/
	public static boolean isGoodProxy(int code) {
		return CODE_PROXY_GOOD == getProductContent(code);
	}

	/*是否是万能代理*/
	public static boolean isPerfectProxy(int code) {
		return CODE_PROXY_PERFECT == getProductContent(code);
	}

	/*是否是动态代理服务*/
	public static boolean isDyNamicProxy(int code) {
		return CODE_PROXY_DYNAMIC == getProductContent(code);
	}

	/*是否是验证码识别服务*/
	public static boolean isIdentifyVcodeGeneral(Integer code) {
		return getProductContent(code) == CODE_VCODE_GENERAL;
	}

	/*########################################################################################*/

	public final static int CODE_PRODUCT_SERVICE_TYPE_ENABLE = 2; //使能类型
	public final static int CODE_PRODUCT_SERVICE_TYPE_COUNT = 1; //次数型产品
	public final static int CODE_PRODUCT_SERVICE_TYPE_TIME = 0; //时间型产品
	/*获取服务方式  时间型 ，使能型，次数型*/

	public static int getServiceMethod(int code) {
		return (code / 10) % 10;
	}

	public static boolean isTimeTypeService(int code) {
		return getServiceMethod(code) == CODE_PRODUCT_SERVICE_TYPE_TIME;
	}

	public static boolean isEnableTypeService(int code) {
		return getServiceMethod(code) == CODE_PRODUCT_SERVICE_TYPE_ENABLE;
	}

	public static boolean isCountTypeService(int code) {
		return getServiceMethod(code) == CODE_PRODUCT_SERVICE_TYPE_COUNT;
	}



	/*计算不同产品的最终服务时间和次数*/
	/*获得购买时间型产品的的最终有效期*/


	/*获得服务单位类型*/
	private static int getServiceUnit(int code) {
		return code % 10;
	}

	private static int getServiceCountUnit(int code) {
		return code % 10;
	}

	/*购买单位为一日*/
	final static int CODE_PRODUCT_TYPE_DAY = 1;

	/*购买单位为一周*/
	final static int CODE_PRODCUT_TYPE_WEEK = 2;

	/*购买单位为一月*/
	final static int CODE_PRODUCT_TYPE_MOUNTH = 3;

	/*购买单位为一季度*/
	final static int CODE_PRODUCT_TYPE_QUARTER = 4;
	/*购买单位为一年*/
	final static int CODE_PRODUCT_TYPE_YEAR = 5;

	/*购买次数单位为百*/
	final static int CODE_PRODUCT_TYPE_HUNDRED = 1;

	/*购买次数单位为千*/
	final static int CODE_PRODUCT_TYPE_THOUSAND = 2;


	public static long getTimeServiceSeconds(int code) {
		int timeUnit = getServiceUnit(code);
		switch (timeUnit) {
			case CODE_PRODUCT_TYPE_DAY:
				return TimeUnit.DAYS.toSeconds(1);
			case CODE_PRODCUT_TYPE_WEEK:
				return TimeUnit.DAYS.toSeconds(1) * 7;
			case CODE_PRODUCT_TYPE_MOUNTH:
				return TimeUnit.DAYS.toSeconds(1) * 30;
			case CODE_PRODUCT_TYPE_QUARTER:
				return TimeUnit.DAYS.toSeconds(1) * 90;
			case CODE_PRODUCT_TYPE_YEAR:
				return TimeUnit.DAYS.toSeconds(1) * 360;
		}
		return 0;
	}





	public static int getServiceCountByProductCode(int code) {
		switch (getServiceUnit(code)) {
			case CODE_PRODUCT_TYPE_HUNDRED:
				return 100;
			case CODE_PRODUCT_TYPE_THOUSAND:
				return 1000;
			default:
				return 1;
		}
	}


	public static MUserService convertProductToMUserService(MProduct mProduct, long uid, int num) {
		//根据产品和购买次数g生成用户服务
		MUserService mUserService = null;
		switch (getServiceMethod(mProduct.getCode())) {
			case CODE_PRODUCT_SERVICE_TYPE_TIME:
				mUserService = MUserService.newTimeService(getProductContent(mProduct.getCode()), getServiceMethod(mProduct.getCode()), uid, mProduct.getDes(), num * ProductUtil.getTimeServiceSeconds(mProduct.getCode()));
				break;
			case CODE_PRODUCT_SERVICE_TYPE_ENABLE:
				mUserService = MUserService.newEnableService(getProductContent(mProduct.getCode()), uid, getServiceMethod(mProduct.getCode()), mProduct.getDes());
				break;
			case CODE_PRODUCT_SERVICE_TYPE_COUNT:
				mUserService = MUserService.newCountService(getProductContent(mProduct.getCode()), getServiceMethod(mProduct.getCode()), uid, mProduct.getDes(),
				                                           num * ProductUtil.getServiceCountByProductCode(mProduct.getCode()));
			default:
		} return mUserService;

	}

	/*订单状态常量*/
	public final static int ORDER_STATE_NOPAY=0;
	public final static int ORDER_STATE_PAYED=1;
	public final static int ORDER_STATE_COMPLETE = 2;
	public final static int ORDER_STATE_CANCEL=-1;

}
