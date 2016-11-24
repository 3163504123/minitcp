package com.ptb.zeus.common.core.model.main;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("m_user_service")
public class MUserService implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/** 服务编号 */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	/** 服务的归属人 */
	protected Integer uid;

	/** 服务标识KEY */
	protected String key;

	/** 商品ID */
	@TableField(value = "p_id")
	protected String pId;

	/** 创建时间 */
	protected Date ctime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPId() {
		return this.pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}
