package com.ptb.zeus.common.core.model.user;

import com.baomidou.mybatisplus.annotations.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 *
 *
 */
@TableName("tb_user")
public class TbUser  implements Serializable {

	public TbUser() {
	}

	public TbUser(String username, String nickname, String phone, String password) {
		this.uname = username;
		this.nickName = nickname;
		this.password = password;
		this.phone = phone;
		this.email = "";
		this.ctime = new Date();
		this.state = 1;
	}


	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	/**
	 * 用户名
	 */
	@TableField(value = "uname")
	protected String uname;

	/**
	 * 密码
	 */
	protected String password;

	/**
	 * 电话
	 */
	protected String phone;

	/**
	 * 邮箱
	 */
	protected String email;

	/**
	 * 创建时间
	 */
	@TableField(value = "ctime")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date ctime;

	/**
	 * 账户状态
	 */
	protected Integer state;

	/**
	 * 昵称
	 */
	@TableField(value = "nick_name")
	protected String nickName;

	/**
	 * 备注
	 */
	protected String remark;

	@TableField(exist = false)
	public List<TbRole> roles;

	public List<TbRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TbRole> roles) {
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		if (ctime == null) {
			ctime = new Date();
		}
		this.ctime = ctime;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
