package com.ptb.zeus.web.main.request;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/25
 * @version 1.0.0
 * @description 类的功能
 */
public class StatementRequest {
	long startDate = 1L;

	long stopDate =  Long.MAX_VALUE;

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getStopDate() {
		return stopDate;
	}

	public void setStopDate(long stopDate) {
		this.stopDate = stopDate;
	}
}
