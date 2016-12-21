package com.ptb.zeus.common.core.utils.security.security;


import com.ptb.zeus.exception.UserException;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.crypto.Cipher;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/11
 * @version 1.0.0
 * @description 生成用户使用的票据
 */
public class TokenUtils {

	static String encodeSalt = "1234567890abcdea";

	static Cipher encryptCipher;

	static Cipher decryptCipher;

	static {
		try {
			decryptCipher = AESTool.getDecryptCipher(encodeSalt);
			encryptCipher = AESTool.getEncryptCipher(encodeSalt);
		} catch (Exception e) {
			e.printStackTrace();
			throw UserException.InerError;
		}
	}

	public static String encode(Token token) {
		try {
			return URLEncoder.encode(AESTool.encrypt(String.format("%d:::%d:::tail", token.getUid(), token.getExpiredTime()), encryptCipher));
		} catch (Exception e) {
			throw UserException.UserTokenParseError;
		}
	}

	public static Token decode(String encodeStr) {
		try {
			String s = new String(AESTool.decrypt(URLDecoder.decode(encodeStr), decryptCipher));
			String[] split = s.split(":::");
			Token token = new Token(split[0], split[1]);
			if (token.expiredTime < System.currentTimeMillis()) {
				throw UserException.UserTokenExpiredError;
			}
			return token;
		} catch (Exception e) {
			throw UserException.UserTokenParseError;
		}
	}




	public static void main(String[] args) {
		Token token = new Token(123456L, 1000);
		String encode = TokenUtils.encode(token);
		System.out.println(encode);
		Token decode = TokenUtils.decode(encode);
		System.out.println(decode.getUid());
		System.out.println(decode.getExpiredTime());

	}
}
