package com.ptb.zeus.common.core.model.main;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * 
 *
 */
@TableName("m_user_service")
public class MUserService  implements Serializable {


	public void initNew(Long uid) {
		this.enabled = 1;
		this.uid = uid;
		this.remark = "";
		this.method = -1;
		this.costNum = 0;
		this.initNum = 0;
		this.initTime = new Date();
		this.deadlineTime = new Date();
		this.ctime = new Date();
		this.skey = "";
	}

	public MUserService(Integer code,Long uid,int method,String remark) {
		initNew(uid);
		this.enabled = 1;
		this.uid = uid;
		this.remark = remark;
		this.method = method;
		this.skey = UUID.randomUUID().toString();
	}

	public MUserService(Integer code,int method, Long uid, String remark, Long timeServiceSeconds) {
		this.pId = code;
		this.uid = uid;
		this.skey = UUID.randomUUID().toString();
		this.enabled = 1;
		this.deadlineTime = new Date(System.currentTimeMillis() + timeServiceSeconds*1000);
		this.method = method;
		this.remark = remark;
	}

	public MUserService(Integer code,int method, Long uid, String remark, Integer timeServiceSeconds) {
		this.pId = code;
		this.uid = uid;
		this.skey = UUID.randomUUID().toString();
		this.enabled = 1;
		this.deadlineTime = new Date(System.currentTimeMillis() + timeServiceSeconds*1000);
		this.method = method;
		this.remark = remark;
	}





	enum EServiceType {
		E_SERVICE_TYPE_GOOD_PORXY(10001),
		E_SERVICE_TYPE_PERFECT_PROXY(10002),
		E_SERVICE_TYPE_DYNAMIC_PROXY(10003),;
		int value;
		EServiceType(int value) {
			this.value = value;
		}
	}

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/** 服务编号 */
	@TableId(type = IdType.AUTO)
	protected Long id;

	/** 服务的归属人 */
	protected Long uid;

	/** 服务标识KEY */
	protected String skey;

	/** 商品ID */
	@TableField(value = "p_id")
	protected Integer pId;

	/** 创建时间 */
	/** 服务截至时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date ctime;

	/** 服务方式 */
	protected Integer method;

	/*备注信息*/
	protected String remark;

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


	protected Integer enabled;


	public MUserService(String skey) {
		this.skey = skey;
	}

	public MUserService() {
	}


	public Integer getEnabled() {
		return enabled;
	}

	public boolean enabled() {
		return this.enabled == 1;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
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

	public Date getInitTime() {
		return initTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setInitTime(Date initTime) {
		this.initTime = initTime;
	}
}
