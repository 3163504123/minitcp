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
@TableName("m_account_user")
public class MAccountUser  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Long id;

	/** 用户点卷数 */
	protected Integer point;

	/** 可提现金额 */
	protected Integer balance;

	/** 用户ID */
	protected Long uid;

	/** 创建时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	protected Date ctime;

	public MAccountUser() {
	}

	public MAccountUser(long uid) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Long getUid() {
		return uid;
	}

	public MAccountUser setUid(Long uid) {
		this.uid = uid;
		return this;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public static MAccountUser newAccount(Long uid) {
		MAccountUser mAccountUser = new MAccountUser();
		mAccountUser.setPoint(0);
		mAccountUser.setBalance(0);
		mAccountUser.setCtime(new Date());
		mAccountUser.setUid(uid);
		return mAccountUser;
	}
}
