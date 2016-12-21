package com.ptb.zeus.common.core.model.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("tb_role")
public class TbRole implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**  */
	@TableField(value = "role_name")
	private String roleName;

	/**  */
	@TableField(value = "role_sign")
	private String roleSign;

	/**  */
	private String description;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleSign() {
		return this.roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
