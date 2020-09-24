package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 客人表，住房的人
 * 
 * @author Autumn
 * @email 
 * @date 2020-03-10 20:31:52
 */
@Table(name = "guest")
public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //客人姓名
    @Column(name = "name")
    private String name;
	
	    //客人性别，0男1女
    @Column(name = "sex")
    private Integer sex;
	
	    //客人电话
    @Column(name = "phone")
    private String phone;
	

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
	 * 设置：客人姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：客人姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：客人性别，0男1女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：客人性别，0男1女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：客人电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：客人电话
	 */
	public String getPhone() {
		return phone;
	}
}
