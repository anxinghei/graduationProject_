package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 角色表
 * 
 * @author Autumn
 * @email 
 * @date 2020-04-01 23:27:40
 */
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //角色名
    @Column(name = "name")
    private String name;
	
	    //角色名中文表示
    @Column(name = "chineseName")
    private String chinesename;
	
	    //权限集
    @Column(name = "perm")
    private String perm;
	

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
	 * 设置：角色名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：角色名中文表示
	 */
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	/**
	 * 获取：角色名中文表示
	 */
	public String getChinesename() {
		return chinesename;
	}
	/**
	 * 设置：权限集
	 */
	public void setPerm(String perm) {
		this.perm = perm;
	}
	/**
	 * 获取：权限集
	 */
	public String getPerm() {
		return perm;
	}
}
