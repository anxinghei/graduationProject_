package com.anxinghei.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 用户表
 * 
 * @author Autumn
 * @email 
 * @date 2020-04-01 23:27:40
 */
@Table(name = "sysuser")
public class Sysuser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //用户昵称
    @Column(name = "nickName")
    private String nickname;
	
	    //登录账号
    @Column(name = "userName")
    private String username;
	
	    //密码
    @Column(name = "password")
    private String password;
	
	    //用户状态，2锁定1正常0禁用
    @Column(name = "status")
    private Integer status;
	
	    //用户解除锁定的时间
    @Column(name = "lockEnding")
    private String lockending;
	
	    //所属角色
    @Column(name = "role")
    private Integer role;
	

	@Override
	public String toString() {
		return "Sysuser [id=" + id + ", nickname=" + nickname + ", username=" + username + ", password=" + password
				+ ", status=" + status + ", lockending=" + lockending + ", role=" + role + "]";
	}
	public Sysuser(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
	public Sysuser() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	 * 设置：用户昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：用户昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：登录账号
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：登录账号
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：用户状态，2锁定1正常0禁用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：用户状态，2锁定1正常0禁用
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：用户解除锁定的时间
	 */
	public void setLockending(String lockending) {
		this.lockending = lockending;
	}
	/**
	 * 获取：用户解除锁定的时间
	 */
	public String getLockending() {
		return lockending;
	}
	/**
	 * 设置：所属角色
	 */
	public void setRole(Integer role) {
		this.role = role;
	}
	/**
	 * 获取：所属角色
	 */
	public Integer getRole() {
		return role;
	}
}
