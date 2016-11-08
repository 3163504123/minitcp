package com.ptb.zeus.web.server.request;

/**
 * Created by eric on 2016/10/20.
 */
public class PageRequest {
	int page = 1;
	int rows = 10;
	String sort;
	String order;

	public int getPage() {
		return page;
	}
	public boolean isAsc() {
		if(order  == null || order.equalsIgnoreCase("asc")) {
			return true;
		}else{
			return false;
		}
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
