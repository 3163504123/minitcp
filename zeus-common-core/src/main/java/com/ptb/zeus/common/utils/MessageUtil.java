package com.ptb.zeus.common.utils;

import com.uranus.ptb.sms.client.SmsClient;

/**
 * Created by eric on 16/5/22.
 */
public class MessageUtil {
    static String registerMessage = "[%s]你正在进行注册操作,您的验证码是%s";
    static String findMessage = "[%s]你正在进行找回密码操作,您的验证码是%s";

    public static boolean sendRegisterMessage(String phone, String validateCode) {
    	SmsClient.setSmsClient(phone, validateCode,SmsClient.REGISTER_MESSAGE_TYPE);
        System.out.println(String.format(registerMessage, phone, validateCode));
        return true;
    }


    public static boolean sendFindPasswordMessage(String phone, String volidateCode) {
    	SmsClient.setSmsClient(phone, volidateCode,SmsClient.FIND_PASSWORD_TYPE);
        System.out.println(String.format(findMessage, phone,volidateCode));
        return true;
    }
}
