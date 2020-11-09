package com.anxing.sys.vo;

import java.util.List;

import com.anxing.sys.entity.Permission;


public class PermissionVo {
	
	private String name;
	private String url;
	private List<Permission> permissions;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public PermissionVo(String name, String url, List<Permission> permissions) {
		super();
		this.name = name;
		this.url = url;
		this.permissions = permissions;
	}
	
}
