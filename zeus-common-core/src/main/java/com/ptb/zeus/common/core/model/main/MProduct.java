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
@TableName("m_product")
public class MProduct  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	/** 商品图片 */
	protected String img;

	/** 价格 */
	protected Integer price;

	/** 商品名称 */
	protected String name;

	/** 描述 */
	protected String des;


	/** 产品编号 其中前两位代表产品编号，后两位用来标识产品销售类型，
	 * 如100001,则代表产品编号为1000，服务类型为01**/
	protected Integer code;

	/** 详情链接 */
	protected String url;

	/** 创建时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	protected Date ctime;

	/** 更新时间 */
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	protected Date utime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCtime() {
		return this.ctime;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setCtime(Date ctime) {
		if(ctime == null) {
			ctime = new Date();
		}
		this.ctime = ctime;
	}

	public Date getUtime() {
		return this.utime;
	}

	public void setUtime(Date utime) {
		if(utime == null) {
			utime = new Date();
		}
		this.utime = utime;
	}

}
