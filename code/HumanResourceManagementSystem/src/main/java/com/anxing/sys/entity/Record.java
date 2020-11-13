package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 日志
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:45
 */
@Table(name = "record")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //操作
    @Column(name = "thing")
    private String thing;
	
	    //时间
    @Column(name = "time")
    private String time;
	
	    //操作对象
    @Column(name = "userid")
    private Integer userid;
	

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
	 * 设置：操作
	 */
	public void setThing(String thing) {
		this.thing = thing;
	}
	/**
	 * 获取：操作
	 */
	public String getThing() {
		return thing;
	}
	/**
	 * 设置：时间
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 获取：时间
	 */
	public String getTime() {
		return time;
	}
	/**
	 * 设置：操作对象
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：操作对象
	 */
	public Integer getUserid() {
		return userid;
	}
}
