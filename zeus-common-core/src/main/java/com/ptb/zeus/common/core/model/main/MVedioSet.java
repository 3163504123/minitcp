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
@TableName("m_vedio_set")
public class MVedioSet  implements Serializable {

	@TableField(exist = false)
	protected static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	protected Integer id;

	/** 名称 */
	protected String name;

	/** 视频集描述 */
	protected String instruction;

	/**  */
	@TableField(value = "study_level")
	protected Integer studyLevel = 0;

	/**  */
	@TableField(value = "teacher_id")
	protected Integer teacherId = 0;

	/**  */
	@TableField(value = "student_cnt")
	protected Integer studentCnt = 0;

	/** 创建时间 */
	@TableField(value = "ctime")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date ctime;

	/** 更新时间 */
	@TableField(value = "utime")
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date utime;

	/**  */
	@TableField(value = "img_url")
	protected String imgUrl;

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

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Integer getStudyLevel() {
		return this.studyLevel;
	}

	public void setStudyLevel(Integer studyLevel) {
		this.studyLevel = studyLevel;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getStudentCnt() {
		return this.studentCnt;
	}

	public void setStudentCnt(Integer studentCnt) {
		this.studentCnt = studentCnt;
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

	public Date getUtime() {
		return this.utime;
	}

	public void setUtime(Date utime) {
		if(utime == null) {
			utime = new Date();
		}
		this.utime = utime;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
