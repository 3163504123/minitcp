package com.ptb.zeus.common.core.model.main;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ptb.zeus.common.core.model.ZModel;

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
@TableName("m_user_service")
public class MUserService extends ZModel<Integer> implements Serializable {
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
	protected String skey;

	/** 商品ID */
	@TableField(value = "p_id")
	protected String pId;

	/** 创建时间 */
	/** 服务截至时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date ctime;

	/** 服务方式 */
	protected Integer method;

	/** 剩余量 */
	@TableField(value = "cost_num")
	protected Integer costNum;

	/** 初始化时的服务量 */
	@TableField(value = "init_num")
	protected Integer initNum;

	/** 服务截至时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@TableField(value = "deadline_time")
	protected Date deadlineTime;

	/** 服务开始时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@TableField(value = "init_time")
	protected Date initTime;

	public MUserService(String skey) {
		this.skey = skey;
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

	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
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
		if(ctime == null) {
			ctime = new Date();
		}
		this.ctime = ctime;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public Integer getCostNum() {
		return costNum;
	}

	public void setCostNum(Integer costNum) {
		this.costNum = costNum;
	}

	public Integer getInitNum() {
		return initNum;
	}

	public void setInitNum(Integer initNum) {

		this.initNum = initNum;
	}

	public Date getDeadlineTime() {
		return deadlineTime;
	}

	public void setDeadlineTime(Date deadlineTime) {
		this.deadlineTime = deadlineTime;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public Date getInitTime() {
		return initTime;
	}

	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}

}
