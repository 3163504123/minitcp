package com.ptb.zeus.web.basic.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/24
 * @version 1.0.0
 * @description 类的功能
 */
public class PageableResponse<T> {
	private static Logger logger = LoggerFactory.getLogger(PageableResponse.class);
	int total;
	List<T> rows;
	public PageableResponse(int total, List<T> records) {
		this.total = total;
		this.rows = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
