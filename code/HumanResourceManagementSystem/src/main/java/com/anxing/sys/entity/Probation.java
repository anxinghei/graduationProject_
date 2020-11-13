package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 试用期员工
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:46
 */
@Table(name = "probation")
public class Probation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //姓名
    @Column(name = "name")
    private String name;
	
	    //职位
    @Column(name = "position")
    private String position;
	
	    //入职年份
    @Column(name = "startyear")
    private Integer startyear;
	
	    //入职月份
    @Column(name = "startmonth")
    private Integer startmonth;
	
	    //薪资
    @Column(name = "salary")
    private Integer salary;
	
	    //联系方式
    @Column(name = "tel")
    private String tel;
	
	    //部门经理/直接上级
    @Column(name = "mid")
    private Integer mid;
	
	    //所属部门
    @Column(name = "department")
    private Integer department;
	

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
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：职位
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：职位
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：入职年份
	 */
	public void setStartyear(Integer startyear) {
		this.startyear = startyear;
	}
	/**
	 * 获取：入职年份
	 */
	public Integer getStartyear() {
		return startyear;
	}
	/**
	 * 设置：入职月份
	 */
	public void setStartmonth(Integer startmonth) {
		this.startmonth = startmonth;
	}
	/**
	 * 获取：入职月份
	 */
	public Integer getStartmonth() {
		return startmonth;
	}
	/**
	 * 设置：薪资
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	/**
	 * 获取：薪资
	 */
	public Integer getSalary() {
		return salary;
	}
	/**
	 * 设置：联系方式
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系方式
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：部门经理/直接上级
	 */
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	/**
	 * 获取：部门经理/直接上级
	 */
	public Integer getMid() {
		return mid;
	}
	/**
	 * 设置：所属部门
	 */
	public void setDepartment(Integer department) {
		this.department = department;
	}
	/**
	 * 获取：所属部门
	 */
	public Integer getDepartment() {
		return department;
	}
}
