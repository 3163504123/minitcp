package com.ptb.zeus.service.main;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/12
 * @version 1.0.0
 * @description 类的功能
 */
public interface IMMobileMsgService {
	void sendRegisterSMS(String phone, String vcode);

	void sendfindPasswordMessage(String phone, String vcode);

}
