package com.anxinghei.sys.vo;

import com.anxinghei.sys.entity.Sysuser;

public class LoginVo {
	
	private String username;
	private String password;
	private String identify;
	private boolean rememberMe;
	
	private static String code="";
	
	@Override
	public String toString() {
		return "LoginVo [username=" + username + ", password=" + password + ", identify=" + identify + ", rememberMe="
				+ rememberMe + "]";
	}
	

	public static String getCode() {
		return code;
	}

	public static void setCode(String code) {
		LoginVo.code = code;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	

}
