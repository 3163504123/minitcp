package com.ptb.zeus.common.core.model;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 *
 * 
 *
 */
@TableName("tb_permission")
public class TbPermission implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	/** 权限名 */
	@TableField(value = "permisson_name")
	protected String permissonName;

	/** 权限标识 */
	@TableField(value = "permisson_sign")
	protected String permissonSign;

	/** 描述 */
	protected String description;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermissonName() {
		return this.permissonName;
	}

	public void setPermissonName(String permissonName) {
		this.permissonName = permissonName;
	}

	public String getPermissonSign() {
		return this.permissonSign;
	}

	public void setPermissonSign(String permissonSign) {
		this.permissonSign = permissonSign;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
