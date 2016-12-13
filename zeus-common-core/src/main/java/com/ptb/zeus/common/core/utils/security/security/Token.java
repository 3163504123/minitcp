package com.ptb.zeus.common.core.utils.security.security;

public class Token {
		Long expiredTime;
		Long uid;

		public Token(String uidStr, String expiredTimeStr) {
			this.expiredTime = Long.parseLong(expiredTimeStr);
			this.uid = Long.parseLong(uidStr);
		}
		public Token(long uid, long expiredSecond) {
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