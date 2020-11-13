package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 教育背景
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:46
 */
@Table(name = "schools")
public class Schools implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //所属简历
    @Column(name = "cid")
    private Integer cid;
	
	    //起始时间：年
    @Column(name = "startyear")
    private Integer startyear;
	
	    //起始时间：月
    @Column(name = "startmonth")
    private Integer startmonth;
	
	    //终止时间：年
    @Column(name = "endyear")
    private Integer endyear;
	
	    //终止时间：月
    @Column(name = "endmonth")
    private Integer endmonth;
	
	    //学校
    @Column(name = "schoolname")
    private String schoolname;
	
	    //专业
    @Column(name = "career")
    private String career;
	
	    //就学情况
    @Column(name = "education")
    private Integer education;
	
	    //在校表现
    @Column(name = "performance")
    private String performance;
	

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
	 * 设置：所属简历
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * 获取：所属简历
	 */
	public Integer getCid() {
		return cid;
	}
	/**
	 * 设置：起始时间：年
	 */
	public void setStartyear(Integer startyear) {
		this.startyear = startyear;
	}
	/**
	 * 获取：起始时间：年
	 */
	public Integer getStartyear() {
		return startyear;
	}
	/**
	 * 设置：起始时间：月
	 */
	public void setStartmonth(Integer startmonth) {
		this.startmonth = startmonth;
	}
	/**
	 * 获取：起始时间：月
	 */
	public Integer getStartmonth() {
		return startmonth;
	}
	/**
	 * 设置：终止时间：年
	 */
	public void setEndyear(Integer endyear) {
		this.endyear = endyear;
	}
	/**
	 * 获取：终止时间：年
	 */
	public Integer getEndyear() {
		return endyear;
	}
	/**
	 * 设置：终止时间：月
	 */
	public void setEndmonth(Integer endmonth) {
		this.endmonth = endmonth;
	}
	/**
	 * 获取：终止时间：月
	 */
	public Integer getEndmonth() {
		return endmonth;
	}
	/**
	 * 设置：学校
	 */
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	/**
	 * 获取：学校
	 */
	public String getSchoolname() {
		return schoolname;
	}
	/**
	 * 设置：专业
	 */
	public void setCareer(String career) {
		this.career = career;
	}
	/**
	 * 获取：专业
	 */
	public String getCareer() {
		return career;
	}
	/**
	 * 设置：就学情况
	 */
	public void setEducation(Integer education) {
		this.education = education;
	}
	/**
	 * 获取：就学情况
	 */
	public Integer getEducation() {
		return education;
	}
	/**
	 * 设置：在校表现
	 */
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	/**
	 * 获取：在校表现
	 */
	public String getPerformance() {
		return performance;
	}
}
