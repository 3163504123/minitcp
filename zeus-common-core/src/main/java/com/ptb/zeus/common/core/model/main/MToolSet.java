package com.ptb.zeus.common.core.model.main;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



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
@TableName("m_tool_set")
public class MToolSet  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	/** API分类名称 */
	protected String name;

	/** 添加时间 */
	@TableField(value = "ctime")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date ctime;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}
