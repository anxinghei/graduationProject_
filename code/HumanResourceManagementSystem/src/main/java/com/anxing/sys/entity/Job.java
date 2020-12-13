package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 职位
 * 
 * @author CBA
 * @email 
 * @date 2020-12-10 19:50:03
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
	
	    //岗位名称
    @Column(name = "simplename")
    private String simplename;
	
	    //职责
    @Column(name = "duty")
    private String duty;
	
	    //岗位要求
    @Column(name = "request")
    private String request;
	
	    //福利待遇
    @Column(name = "welfare")
    private String welfare;
	
	    //所属公司
    @Column(name = "cid")
    private Integer cid;
	
	    //1启用，0停用
    @Column(name = "status")
    private Integer status;
	
	    //0实习生，1校招，2社招
    @Column(name = "jclass")
    private Integer jclass;
	

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
	/**
	 * 设置：职责
	 */
	public void setDuty(String duty) {
		this.duty = duty;
	}
	/**
	 * 获取：职责
	 */
	public String getDuty() {
		return duty;
	}
	/**
	 * 设置：岗位要求
	 */
	public void setRequest(String request) {
		this.request = request;
	}
	/**
	 * 获取：岗位要求
	 */
	public String getRequest() {
		return request;
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
	/**
	 * 设置：1启用，0停用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：1启用，0停用
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：0实习生，1校招，2社招
	 */
	public void setClass(Integer jclass) {
		this.jclass = jclass;
	}
	/**
	 * 获取：0实习生，1校招，2社招
	 */
	public Integer getJclass() {
		return jclass;
	}
}
