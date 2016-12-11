package com.ptb.zeus.common.core.utils;

import com.ptb.zeus.common.core.utils.security.DES;
import com.ptb.zeus.exception.UserException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.math.RandomUtils;


/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/11
 * @version 1.0.0
 * @description 生成用户使用的票据
 */
public class TokenUtils {
	public static class MUserToken {
		Long expiredTime;
		Long uid;



		public MUserToken(String uidStr, String expiredTimeStr) {
			this.expiredTime = Long.parseLong(expiredTimeStr);
			this.uid = Long.parseLong(uidStr);
		}
		public MUserToken(long uid, long expiredSecond) {
			this.expiredTime = System.currentTimeMillis() +  expiredSecond * 1000;
			this.uid = uid;
		}


		public long getExpiredTime() {
			return expiredTime;
		}

		public void setExpiredTime(long expiredTime) {
			this.expiredTime = expiredTime;
		}

		public long getUid() {
			return uid;
		}

		public void setUid(long uid) {
			this.uid = uid;
		}
	}

	static String encodeSalt = "minitcpxxx";

	public static String encode(MUserToken mUserToken) {
		return Base64.encodeBase64String(DES.encrypt(String.format("%d:::%d:::%d", mUserToken.getUid(), mUserToken.getExpiredTime(), RandomUtils.nextInt()).getBytes(), encodeSalt));
	}

	public static MUserToken decode(String encodeStr) {
		try {
			String s = new String(DES.decrypt(Base64.decodeBase64(encodeStr), encodeSalt));
			String[] split = s.split(":::");
			MUserToken mUserToken = new MUserToken(split[0], split[1]);
			if (mUserToken.expiredTime < System.currentTimeMillis()) {
				throw UserException.UserTokenExpiredError;
			}
			return mUserToken;
		} catch (Exception e) {
			throw UserException.UserTokenParseError;
		}
	}

	public static void main(String[] args) {
		MUserToken mUserToken = new MUserToken(123456L, 1000);
		String encode = TokenUtils.encode(mUserToken);
		System.out.println(encode);
		MUserToken decode = TokenUtils.decode(encode);
		System.out.println(decode.getUid());

	}
}
