package com.ptb.zeus.common.core.model.main;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * 
 *
 */
@TableName("m_tool")
public class MTool  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	@TableField(value = "ctime")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date ctime;

	/** API名称 */
	protected String name;

	/** API描述 */
	protected String instruction;

	/** API当前状态 */
	protected Integer state;

	/** 单次价格 */
	protected Integer price;

	/** 演示的网页地址 */
	@TableField(value = "demo_url")
	protected String demoUrl;

	/** 封面图的URL地址 */
	@TableField(value = "img_url")
	protected String imgUrl;

	/** api描述的网页地址 */
	@TableField(value = "api_desc_url")
	protected String apiDescUrl;

	/** 视频地址 */
	@TableField(value = "vedio_url")
	protected String vedioUrl;

	/** 使用的总次数 */
	@TableField(value = "use_cnt")
	protected Integer useCnt;

	/** 使用的用户数
 */
	@TableField(value = "used_user_cnt")
	protected Integer usedUserCnt;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		if(ctime == null) {
			this.ctime = new Date();
		}else{
			this.ctime = ctime;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDemoUrl() {
		return this.demoUrl;
	}

	public void setDemoUrl(String demoUrl) {
		this.demoUrl = demoUrl;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getApiDescUrl() {
		return this.apiDescUrl;
	}

	public void setApiDescUrl(String apiDescUrl) {
		this.apiDescUrl = apiDescUrl;
	}

	public String getVedioUrl() {
		return this.vedioUrl;
	}

	public void setVedioUrl(String vedioUrl) {
		this.vedioUrl = vedioUrl;
	}

	public Integer getUseCnt() {
		return this.useCnt;
	}

	public void setUseCnt(Integer useCnt) {
		if(useCnt == null) {
			this.useCnt = 0;
		}else {
			this.useCnt = useCnt;
		}
	}

	public Integer getUsedUserCnt()
	{
		return this.usedUserCnt;
	}

	public void setUsedUserCnt(Integer usedUserCnt) {
		if(usedUserCnt == null) {
			this.usedUserCnt = 0;
		}else {
			this.usedUserCnt = usedUserCnt;
		}
	}

}
