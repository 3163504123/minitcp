package com.ptb.zeus.common.web.bean.request;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class ReqCombination {

	public static  final String CAPACITY = "capacitymedia";
	public static  final String HOT = "hotmedia";
	public static  final String HOTARTICLE = "hotarticlemedia";

	@NotNull(message = "接口类型不能为空")
	private String itype;
	@NotNull(message = "维度不能为空")
	private String otype;
	@Range(min = 1, max = 2, message = "不支持此平台")
	private int type;

	@Range(min = 0, max = Integer.MAX_VALUE, message = "开始或结果索引不正确")
	private int start = 0;

	@Range(min = 0, max = Integer.MAX_VALUE, message = "开始或结果索引不正确")
	private int end = 10;

	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public String getOtype() {
		return otype;
	}
	public void setOtype(String otype) {
		this.otype = otype;
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

	public String getOtypeCapacitymedia(String otype){
		String isOtype = null;
		if(otype.contains("forward")){
			isOtype = "spread";
		}else if (otype.contains("comment")){
			isOtype = "comment";
		}else if(otype.contains("zan")){
			isOtype = "zan";
		}
		return isOtype;
	}

	public String getOtypeHotarticlemedia(String otype){
		String isOtype = null;
		if (otype.contains("time")){
			isOtype = "recent";
		}else if (otype.contains("hot")){
			isOtype = "hot";
		}
		return isOtype;

	}

	public String getOtypeHotmedia(String otype){
		String isOtype = null;
		if (otype.contains("read")){
			isOtype = "read";
		}else if (otype.contains("zan")){
			isOtype = "zan";
		}
		return isOtype;
	}
}
