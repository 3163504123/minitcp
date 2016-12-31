package com.ptb.zeus.web.main.request;

/**
 * Created by eric on 16/7/4.
 */
public class NewsReqeust {
	long st = System.currentTimeMillis();
	int size = 10;


	public long getSt() {
		return st;
	}

	public void setSt(long st) {
		this.st = st;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
