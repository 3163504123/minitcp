package com.ptb.zeus.service.main;

import com.ptb.zeus.common.core.model.main.MProxy;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/9
 * @version 1.0.0
 * @description 类的功能
 */
public interface IMProxyService {


	List<MProxy> select(MProxy mProxy,int offset,int limit);


	/*class ThreadUpdateFreeProxy implements Runnable {
		@Override
		public void run() {
			String url = "http://api.goubanjia.com/api/get.shtml?order=87e52437da10c3071804f3b6a3b4806a&num=5000&carrier=0&protocol=0&an1=1&an2=2&an3=3&sp1=1&sp2=2&sp3=3&sort=2&system=1&distinct=0&rettype=0&seprator=%0D%0A&f_loc=1&f_anoy=1&f_speed=1";
			while(true) {
				boolean post = HttpClientUtils.post(url, null, 1L);
			}
		}
	}
	public IMProxyService() {
		Thread thread = new Thread();
	}

	public static void main(String[] args) {
		String url = "http://api.goubanjia.com/api/get.shtml?order=87e52437da10c3071804f3b6a3b4806a&num=5000&carrier=0&protocol=0&an1=1&an2=2&an3=3&sp1=1&sp2=2&sp3=3&sort=2&system=1&distinct=0&rettype=0&seprator=%0D%0A&f_loc=1&f_anoy=1&f_speed=1";
	}*/
}
