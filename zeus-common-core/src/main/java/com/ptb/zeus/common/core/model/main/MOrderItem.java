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
@TableName("m_order_item")
public class MOrderItem  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/** 订单项编号 */
	@TableId(type = IdType.UUID)
	protected String id;

	/** 订单编号
 */
	@TableField(value = "order_id")
	protected String orderId;

	/** 商品ID */
	@TableField(value = "p_id")
	protected Integer pId;

	/** 数量 */
	protected Integer number;

	/** 原始价格 */
	@TableField(value = "raw_price")
	protected Integer rawPrice;

	/** 真实价格 */
	@TableField(value = "real_price")
	protected String realPrice;

	/** 总额 */
	protected Integer amount;

	/** 创建时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	protected Date ctime;

	public MOrderItem() {
	}

	public MOrderItem(String orderID) {
		this.orderId = orderID;
	}

	public MOrderItem(String orderId, int productID, int price,int num) {
		this.orderId = orderId;
		this.pId = productID;
		this.number = num;
		this.rawPrice =  price;
		this.rawPrice = price;
		this.amount = price * num;

	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getPId() {
		return this.pId;
	}

	public void setPId(Integer pId) {
		this.pId = pId;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getRawPrice() {
		return this.rawPrice;
	}

	public void setRawPrice(Integer rawPrice) {
		this.rawPrice = rawPrice;
	}

	public String getRealPrice() {
		return this.realPrice;
	}

	public void setRealPrice(String realPrice) {
		this.realPrice = realPrice;
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

}
