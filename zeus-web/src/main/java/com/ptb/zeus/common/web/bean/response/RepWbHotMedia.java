package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.WbHotMedia;

import java.util.List;

/**
 * 微博热媒体
 * @author lenovo
 *
 */
public class RepWbHotMedia {
	private int totalNum;
	private List<WbHotMedia> list;
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public List<WbHotMedia> getList() {
		return list;
	}
	public void setList(List<WbHotMedia> list) {
		this.list = list;
	}

}
