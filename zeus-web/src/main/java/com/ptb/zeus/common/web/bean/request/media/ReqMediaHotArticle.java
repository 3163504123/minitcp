package com.ptb.zeus.common.web.bean.request.media;

import org.hibernate.validator.constraints.Range;

/**
 * 微信微博媒体热文
 * @author lenovo
 *
 */
public class ReqMediaHotArticle {

	@Range(min = 1, max = 2, message = "不支持此平台")
	private int type;

	@Range(min = 0, max = Integer.MAX_VALUE, message = "开始或结果索引不正确")
	private int start = 0;

	@Range(min = 0, max = Integer.MAX_VALUE, message = "开始或结果索引不正确")
	private int end = 10;

	private String atype;

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

}
