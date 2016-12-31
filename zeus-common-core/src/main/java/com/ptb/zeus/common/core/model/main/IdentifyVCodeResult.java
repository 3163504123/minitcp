package com.ptb.zeus.common.core.model.main;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/12/31
 * @version 1.0.0
 * @description 类的功能
 */
public class IdentifyVCodeResult {
	int err_no;
	String err_str;
	String pid_id;
	String pic_str;
	String md5;
	String str_debug;

	public int getErr_no() {
		return err_no;
	}

	public void setErr_no(int err_no) {
		this.err_no = err_no;
	}

	public String getErr_str() {
		return err_str;
	}

	public void setErr_str(String err_str) {
		this.err_str = err_str;
	}

	public String getPid_id() {
		return pid_id;
	}

	public void setPid_id(String pid_id) {
		this.pid_id = pid_id;
	}

	public String getPic_str() {
		return pic_str;
	}

	public void setPic_str(String pic_str) {
		this.pic_str = pic_str;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getStr_debug() {
		return str_debug;
	}

	public void setStr_debug(String str_debug) {
		this.str_debug = str_debug;
	}
}
