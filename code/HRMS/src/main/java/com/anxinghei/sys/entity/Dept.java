package com.anxinghei.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 部门表
 * 
 * @author CBA
 * @email 
 * @date 2020-12-11 21:10:34
 */
@Table(name = "dept")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //部门名称
    @Column(name = "name")
    private String name;
	
	    //中文名称
    @Column(name = "simplename")
    private String simplename;
	
	    //部门介绍
    @Column(name = "description")
    private String description;
	
	    //部门主管，0默认向老板负责
    @Column(name = "manager")
    private Integer manager;
	

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
	 * 设置：部门名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：部门名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：中文名称
	 */
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	/**
	 * 获取：中文名称
	 */
	public String getSimplename() {
		return simplename;
	}
	/**
	 * 设置：部门介绍
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：部门介绍
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：部门主管，0默认向老板负责
	 */
	public void setMagager(Integer magager) {
		this.manager = magager;
	}
	/**
	 * 获取：部门主管，0默认向老板负责
	 */
	public Integer getMagager() {
		return manager;
	}
}
