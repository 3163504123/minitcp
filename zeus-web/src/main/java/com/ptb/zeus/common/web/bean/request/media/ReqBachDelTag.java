package com.ptb.zeus.common.web.bean.request.media;


import org.hibernate.validator.constraints.NotBlank;

public class ReqBachDelTag {
	@NotBlank(message = "标签不能为空")
	protected String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
