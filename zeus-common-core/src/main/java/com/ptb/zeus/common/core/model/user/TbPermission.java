package com.ptb.zeus.common.core.model.user;

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
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 权限名 */
	@TableField(value = "permisson_name")
	private String permissonName;

	/** 权限标识 */
	@TableField(value = "permisson_sign")
	private String permissonSign;

	/** 描述 */
	private String description;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
