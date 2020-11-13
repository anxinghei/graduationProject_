package com.anxing.sys.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.Data;


/**
 * 简历
 * 
 * @author CBA
 * @email 
 * @date 2020-11-13 14:13:45
 */
@Data
@Table(name = "resume")
public class Resume implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private Integer id;
	
	    //姓名
    @NotNull(message = "姓名不能为空")
    @Column(name = "name")
    private String name;
	
	    //自我介绍
    @Column(name = "selfintroduction")
    private String selfintroduction;
	
	    //年龄
    @Column(name = "age")
    private Integer age;
	
	    //工作年限
    @Column(name = "years")
    private Integer years;
	
	    //联系电话
    @NotNull(message = "联系电话不能为空")
    @Column(name = "tel")
    private String tel;
	
	    //通知邮箱
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @Column(name = "email")
    private String email;
	
	    //意向岗位
    @NotNull(message = "意向岗位不能为空")
    @Column(name = "job")
    private Integer job;
	
	    //意向城市
    @NotNull(message = "意向城市不能为空")
    @Column(name = "city")
    private Integer city;
	
	    //意向薪资
    @Column(name = "salary")
    private Integer salary;
	
	    //入职时间
    @Column(name = "intime")
    private String intime;
	
	    //教育背景
    @NotNull(message = "教育背景不能为空")
    @Column(name = "schools")
    private String schools;
	
	    //技能掌握
    @Column(name = "skills")
    private String skills;
	
	    //工作经历
    @Column(name = "works")
    private String works;
	
	    //紧急联系人
    @NotNull(message = "紧急联系人不能为空")
    @Column(name = "oname")
    private String oname;
	
	    //关系
    @NotNull(message = "关系不能为空")
    @Column(name = "relationship")
    private String relationship;
	
	    //联系方式
    @NotNull(message = "紧急联系人的联系方式不能为空")
    @Column(name = "otel")
    private String otel;
	
	    //内推码
    @Column(name = "pushcode")
    private String pushcode;
	

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
	 * 设置：自我介绍
	 */
	public void setSelfintroduction(String selfintroduction) {
		this.selfintroduction = selfintroduction;
	}
	/**
	 * 获取：自我介绍
	 */
	public String getSelfintroduction() {
		return selfintroduction;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：工作年限
	 */
	public void setYears(Integer years) {
		this.years = years;
	}
	/**
	 * 获取：工作年限
	 */
	public Integer getYears() {
		return years;
	}
	/**
	 * 设置：联系电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：通知邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：通知邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：意向岗位
	 */
	public void setJob(Integer job) {
		this.job = job;
	}
	/**
	 * 获取：意向岗位
	 */
	public Integer getJob() {
		return job;
	}
	/**
	 * 设置：意向城市
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	/**
	 * 获取：意向城市
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * 设置：意向薪资
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	/**
	 * 获取：意向薪资
	 */
	public Integer getSalary() {
		return salary;
	}
	/**
	 * 设置：入职时间
	 */
	public void setIntime(String intime) {
		this.intime = intime;
	}
	/**
	 * 获取：入职时间
	 */
	public String getIntime() {
		return intime;
	}
	/**
	 * 设置：教育背景
	 */
	public void setSchools(String schools) {
		this.schools = schools;
	}
	/**
	 * 获取：教育背景
	 */
	public String getSchools() {
		return schools;
	}
	/**
	 * 设置：技能掌握
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}
	/**
	 * 获取：技能掌握
	 */
	public String getSkills() {
		return skills;
	}
	/**
	 * 设置：工作经历
	 */
	public void setWorks(String works) {
		this.works = works;
	}
	/**
	 * 获取：工作经历
	 */
	public String getWorks() {
		return works;
	}
	/**
	 * 设置：紧急联系人
	 */
	public void setOname(String oname) {
		this.oname = oname;
	}
	/**
	 * 获取：紧急联系人
	 */
	public String getOname() {
		return oname;
	}
	/**
	 * 设置：关系
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	/**
	 * 获取：关系
	 */
	public String getRelationship() {
		return relationship;
	}
	/**
	 * 设置：联系方式
	 */
	public void setOtel(String otel) {
		this.otel = otel;
	}
	/**
	 * 获取：联系方式
	 */
	public String getOtel() {
		return otel;
	}
	/**
	 * 设置：内推码
	 */
	public void setPushcode(String pushcode) {
		this.pushcode = pushcode;
	}
	/**
	 * 获取：内推码
	 */
	public String getPushcode() {
		return pushcode;
	}
}
