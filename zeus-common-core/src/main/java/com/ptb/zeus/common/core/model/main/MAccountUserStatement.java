package com.ptb.zeus.common.core.model.main;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 
 *
 */
@TableName("m_account_user_statement")
public class MAccountUserStatement  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.UUID)
	protected String id;

	/** 用户ID */
	protected Long uid;

	/** 帐户ID */
	@TableField(value = "account_id")
	protected Long accountId;

	/** 金额 */
	protected Integer amount;

	/** 流水来源 */
	protected String source;

	/** 备注 */
	protected String remark;

	/** 创建时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	protected Date ctime;

	public MAccountUserStatement(
			Long uid, Long id, Integer price, String source, String des) {
		this.uid = uid;
		this.accountId = id;
		this.amount = price;
		this.source = source;
		this.remark = des;
		this.ctime = new Date();
	}

	public MAccountUserStatement() {


	}

	public MAccountUserStatement(Long accountId) {
		this.accountId = accountId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}
