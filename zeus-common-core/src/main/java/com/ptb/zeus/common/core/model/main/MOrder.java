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
@TableName("m_order")
public class MOrder implements Serializable {







	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**
	 * 订单编号
	 */
	@TableId(type = IdType.UUID)
	private String id;

	/**
	 * 用户ID
	 */
	@TableField(value = "account_id")
	private Long accountId;

	/**
	 * 消费金额
	 */
	private Integer amount;

	/**
	 * 创建时间
	 */
	private Date ctime;

	/**
	 * 订单状态  0 未支付 1 已付款 2 已完成 -1 已取消
	 */
	private Integer state;


	/**
	 * 备注信息
	 */
	private String remark;

	/*订单状态常量*/
	public final static int ORDER_STATE_NOPAY=0;
	public final static int ORDER_STATE_PAYED=1;
	public final static int ORDER_STATE_COMPLETE = 2;
	public final static int ORDER_STATE_CANCEL=-1;
	public MOrder() {
	}

	public MOrder(long accountID, String orderID) {
		this.accountId = accountID;
		this.id = orderID;
	}



	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getAccountId() {
		return this.accountId;
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

	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static MOrder newOrder(Long accountId, int price) {
		MOrder mOrder = new MOrder();
		mOrder.ctime = new Date();
		mOrder.accountId = accountId;
		mOrder.state = 0;
		mOrder.amount = price;
		return mOrder;
	}
}
