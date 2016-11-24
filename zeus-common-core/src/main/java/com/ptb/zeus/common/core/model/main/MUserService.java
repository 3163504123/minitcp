package com.ptb.zeus.common.core.model.main;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 
 *
 */
@TableName("m_user_service")
public class MUserService implements Serializable {
	enum EServiceType {
		E_SERVICE_TYPE_GOOD_PORXY(10001),
		E_SERVICE_TYPE_PERFECT_PROXY(10002),
		E_SERVICE_TYPE_DYNAMIC_PROXY(10003),
		;

		int value;
		EServiceType(int value) {
			this.value = value;
		}
	}

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

	public MUserService(String key) {
		this.key = key;
	}

	public MUserService() {
	}

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