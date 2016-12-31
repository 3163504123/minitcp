package com.ptb.zeus.common.core.utils;

import com.ptb.zeus.common.core.model.main.MUserService;
import com.ptb.zeus.common.core.utils.business.ProductUtil;
import com.ptb.zeus.exception.UserException;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/31
 * @version 1.0.0
 * @description 类的功能
 */
public class UserServiceUtils {

	public static boolean isOK(MUserService mUserService, int codeProxyGood) {
		boolean ret = false;
		if (mUserService.getEnabled() <= 0) {
			throw UserException.ServiceOverError;
		}

		if (mUserService.getpId() != codeProxyGood) {
			throw UserException.ServiceKeyError;
		}

		switch (ProductUtil.getServiceMethod(mUserService.getMethod())) {
			case ProductUtil.CODE_PRODUCT_SERVICE_TYPE_COUNT:
				ret = mUserService.getCostNum() < mUserService.getInitNum();
			case ProductUtil.CODE_PRODUCT_SERVICE_TYPE_TIME:
				ret = mUserService.getDeadlineTime().getTime() < System.currentTimeMillis();
			case ProductUtil.CODE_PRODUCT_SERVICE_TYPE_ENABLE:
				ret = mUserService.getEnabled() == 1;

		}
		if(ret == false) {
			throw UserException.ServiceOverError;
		}
		return ret;
	}
}
