package com.anxinghei.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 正式员工职位
 * 
 * @author CBA
 * @email 
 * @date 2020-12-11 21:10:34
 */
@Table(name = "position")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //职位名称
    @Column(name = "name")
    private String name;
	
	    //岗位名称
    @Column(name = "simplename")
    private String simplename;
	

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
	 * 设置：职位名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：职位名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：岗位名称
	 */
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getSimplename() {
		return simplename;
	}
}
