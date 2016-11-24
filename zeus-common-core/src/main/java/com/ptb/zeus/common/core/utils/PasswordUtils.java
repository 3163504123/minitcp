package com.ptb.zeus.common.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/10/27
 * @version 1.0.0
 * @description 类的功能
 */
public class PasswordUtils {
	private static Logger logger = LoggerFactory.getLogger(PasswordUtils.class);
	static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(9);

	public static PasswordEncoder getPasswordEncoder() {
		return bCryptPasswordEncoder;
	}

	public static String encode(CharSequence charSequence) {
		return bCryptPasswordEncoder.encode(charSequence);
	}

	public static boolean match(String rawPassword, String encodePassword) {
		return bCryptPasswordEncoder.matches(rawPassword, encodePassword);
	}
}
