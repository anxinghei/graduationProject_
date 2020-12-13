package com.anxinghei.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 权限表
 * 
 * @author Autumn
 * @email 
 * @date 2020-04-01 23:27:40
 */
@Table(name = "permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //链接网址
    @Column(name = "url")
    private String url;
	
	    //具体权限
    @Column(name = "perm")
    private String perm;
	
	    //权限名称
    @Column(name = "name")
    private String name;
	
	    //父级菜单id
    @Column(name = "pid")
    private Integer pid;
	

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
	 * 设置：链接网址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接网址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：具体权限
	 */
	public void setPerm(String perm) {
		this.perm = perm;
	}
	/**
	 * 获取：具体权限
	 */
	public String getPerm() {
		return perm;
	}
	/**
	 * 设置：权限名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：权限名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：父级菜单id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父级菜单id
	 */
	public Integer getPid() {
		return pid;
	}
}
