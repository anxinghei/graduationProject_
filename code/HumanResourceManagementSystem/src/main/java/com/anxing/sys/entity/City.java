package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 工作城市
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:46
 */
@Table(name = "city")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //城市
    @Column(name = "name")
    private String name;
	
	    //详细地址
    @Column(name = "addr")
    private String addr;
	
	    //所属公司
    @Column(name = "cid")
    private Integer cid;
	

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
	 * 设置：城市
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：城市
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：所属公司
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * 获取：所属公司
	 */
	public Integer getCid() {
		return cid;
	}
}
