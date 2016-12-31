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


	private static MUserService initNew(Long uid) {
		MUserService mUserService = new MUserService();
		mUserService.enabled = 1;
		mUserService.uid = uid;
		mUserService.remark = "";
		mUserService.method = -1;
		mUserService.costNum = 0;
		mUserService.initNum = 0;
		mUserService.initTime = new Date();
		mUserService.deadlineTime = new Date();
		mUserService.ctime = new Date();
		mUserService.skey = "";
		return mUserService;
	}

	public static MUserService newTimeService(Integer code,int method, Long uid, String remark, Long timeServiceSeconds){
		MUserService mUserService = initNew(uid);
		mUserService.pId = code;
		mUserService.uid = uid;
		mUserService.skey = UUID.randomUUID().toString();
		mUserService.enabled = 1;
		mUserService.deadlineTime = new Date(System.currentTimeMillis() + timeServiceSeconds*1000);
		mUserService.method = method;
		mUserService.remark = remark;
		return mUserService;
	}

	public static MUserService newEnableService(Integer code,Long uid,int method,String remark) {
		MUserService mUserService = initNew(uid);
		mUserService.enabled = 1;
		mUserService.uid = uid;
		mUserService.remark = remark;
		mUserService.method = method;
		mUserService.skey = UUID.randomUUID().toString();
		return mUserService;
	}

	public static MUserService newCountService(Integer code,int method, Long uid, String remark, int count) {
		MUserService mUserService = initNew(uid);
		mUserService.pId = code;
		mUserService.uid = uid;
		mUserService.skey = UUID.randomUUID().toString();
		mUserService.enabled = 1;
		mUserService.method = method;
		mUserService.remark = remark;
		mUserService.setInitNum(count);
		return mUserService;

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
