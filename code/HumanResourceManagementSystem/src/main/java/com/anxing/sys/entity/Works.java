package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 工作经历
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:45
 */
@Table(name = "works")
public class Works implements Serializable {
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
	
	    //公司
    @Column(name = "campanyname")
    private String campanyname;
	
	    //职位
    @Column(name = "position")
    private String position;
	
	    //工作
    @Column(name = "work")
    private String work;
	

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
	 * 设置：公司
	 */
	public void setCampanyname(String campanyname) {
		this.campanyname = campanyname;
	}
	/**
	 * 获取：公司
	 */
	public String getCampanyname() {
		return campanyname;
	}
	/**
	 * 设置：职位
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：职位
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：工作
	 */
	public void setWork(String work) {
		this.work = work;
	}
	/**
	 * 获取：工作
	 */
	public String getWork() {
		return work;
	}
}
