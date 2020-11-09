package com.anxing.sys.vo;

import java.util.List;

import com.anxing.sys.entity.Sysuser;


public class MemberVo {

	private static Sysuser sysuser=null;
	private Sysuser user;
	private List<PermissionVo> rules;
	
	public Sysuser getUser() {
		return user;
	}
	public void setUser(Sysuser user) {
		this.user = user;
	}
	public static Sysuser getSysuser() {
		return sysuser;
	}
	public static void setSysuser(Sysuser user) {
		sysuser = user;
	}
	public List<PermissionVo> getRules() {
		return rules;
	}
	public void setRules(List<PermissionVo> rules) {
		this.rules = rules;
	}
	
}
