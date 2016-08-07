package com.ptb.zeus.common.common;

/**
 * 7天统计阅读数
 * @author lenovo
 *
 */
public class PointNum {
	private long time;
	private int num;

	public PointNum(long time, int num) {
		this.time = time;
		this.num= num;
	}

	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	

}
