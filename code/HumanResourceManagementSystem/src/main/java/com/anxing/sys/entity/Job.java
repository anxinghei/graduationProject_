package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 职位
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:46
 */
@Table(name = "job")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //职位
    @Column(name = "name")
    private String name;
	
	    //职位描述
    @Column(name = "description")
    private String description;
	
	    //福利待遇
    @Column(name = "welfare")
    private String welfare;
	
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
	 * 设置：职位
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：职位
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：职位描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：职位描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：福利待遇
	 */
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	/**
	 * 获取：福利待遇
	 */
	public String getWelfare() {
		return welfare;
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
