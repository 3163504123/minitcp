package com.ptb.zeus.common.web.bean.response;

import com.ptb.zeus.common.common.WxHotMedia;

import java.util.List;

/**
 * 微信热媒体
 * @author lenovo
 *
 */
public class RepWxHotMedia {

	private int totalNum;
	private List<WxHotMedia> list;
	
	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public List<WxHotMedia> getList() {
		return list;
	}

	public void setList(List<WxHotMedia> list) {
		this.list = list;
	}
}
