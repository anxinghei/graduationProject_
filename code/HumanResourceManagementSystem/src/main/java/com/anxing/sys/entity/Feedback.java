package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 简历投递反馈
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:45
 */
@Table(name = "feedback")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //简历
    @Column(name = "rid")
    private Integer rid;
	
	    //招聘进度，0不合适，1待洽谈，2通过一面，20未通过一面，3通过二面，30未通过二面，4通过终面，40未通过终面，5录用，50取消录用
    @Column(name = "schedule")
    private Integer schedule;
	
	    //面试情况
    @Column(name = "description")
    private String description;
	
	    //投递时间
    @Column(name = "time")
    private String time;
	

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：简历
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * 获取：简历
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * 设置：招聘进度，0不合适，1待洽谈，2通过一面，20未通过一面，3通过二面，30未通过二面，4通过终面，40未通过终面，5录用，50取消录用
	 */
	public void setSchedule(Integer schedule) {
		this.schedule = schedule;
	}
	/**
	 * 获取：招聘进度，0不合适，1待洽谈，2通过一面，20未通过一面，3通过二面，30未通过二面，4通过终面，40未通过终面，5录用，50取消录用
	 */
	public Integer getSchedule() {
		return schedule;
	}
	/**
	 * 设置：面试情况
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：面试情况
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：投递时间
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 获取：投递时间
	 */
	public String getTime() {
		return time;
	}
}
