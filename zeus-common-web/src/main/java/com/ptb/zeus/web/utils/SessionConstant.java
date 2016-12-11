package com.ptb.zeus.web.utils;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 类的功能
 */
public enum SessionConstant {
	E_SESSION_USERNAME,
	E_SESSION_USERID, E_SESSION_IMGVCODE, E_SESSION_PHONEVCODE,
	E_SESSION_PHONENUM;

	public static final String KEY_UUID = "uuid";
	public static final long DEFAULT_UUID_EXPIRED_TIME = 7200L;  //默认TOKEN有效期为7200秒
}
