package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 学历
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:46
 */
@Table(name = "education")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //学历
    @Column(name = "name")
    private String name;
	
	    //就读年限
    @Column(name = "years")
    private Integer years;
	
	    //是否统招，1是0否
    @Column(name = "entrance")
    private Integer entrance;
	
	    //是否全日制，1是0否
    @Column(name = "fulltime")
    private Integer fulltime;
	

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
	 * 设置：学历
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：学历
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：就读年限
	 */
	public void setYears(Integer years) {
		this.years = years;
	}
	/**
	 * 获取：就读年限
	 */
	public Integer getYears() {
		return years;
	}
	/**
	 * 设置：是否统招，1是0否
	 */
	public void setEntrance(Integer entrance) {
		this.entrance = entrance;
	}
	/**
	 * 获取：是否统招，1是0否
	 */
	public Integer getEntrance() {
		return entrance;
	}
	/**
	 * 设置：是否全日制，1是0否
	 */
	public void setFulltime(Integer fulltime) {
		this.fulltime = fulltime;
	}
	/**
	 * 获取：是否全日制，1是0否
	 */
	public Integer getFulltime() {
		return fulltime;
	}
}
