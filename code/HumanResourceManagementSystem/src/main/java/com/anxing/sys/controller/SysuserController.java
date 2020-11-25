package com.anxing.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anxing.sys.entity.Permission;
import com.anxing.sys.entity.Role;
import com.anxing.sys.mapper.PermissionMapper;
import com.anxing.sys.mapper.RoleMapper;
import com.anxing.sys.mapper.SysuserMapper;
import com.anxing.sys.util.BaiscData;
import com.anxing.sys.vo.MemberVo;
import com.anxing.sys.vo.PermissionVo;

// extends BaseController<SysuserBiz,Sysuser>

@RestController
@RequestMapping("sysuser")
public class SysuserController  {
	
	@Autowired
	private RoleMapper authGroupService;
	@Autowired
	private PermissionMapper ruleService;
	@Autowired
	private SysuserMapper sysuserMapper;

	@PostMapping("/logouting")
	public String logouting() {
		MemberVo.setSysuser(null);
		return "success";
	}
	
	@RequestMapping("/toHome")
	public MemberVo toHome() {

		// 得到当前用户
//		Subject subject = SecurityUtils.getSubject();
//		Sysuser member = (Sysuser)subject.getPrincipal();

		System.out.println("当前用户:"+MemberVo.getSysuser());
        int groupId=MemberVo.getSysuser().getRole();
        System.out.println("groupId:"+groupId);
        Role authGroup=authGroupService.selectByPrimaryKey(groupId);
        // 得到角色的权限集：String-->int[]
     	String authString=authGroup.getPerm();
     	int[] rulesInt=BaiscData.splitString(authString);

     	// 划分一二级菜单
     	List<Permission> firstRules=new ArrayList<Permission>();
     	List<PermissionVo> lists=new ArrayList<PermissionVo>();
     	Permission authRule=new Permission();
     	PermissionVo permissionVo=null;
     	for (int i = 0; i < rulesInt.length; i++) {
     		authRule=ruleService.selectByPrimaryKey(rulesInt[i]);
     		if (0==authRule.getPid()) {
				firstRules=ruleService.getPermissionsByUser(authRule.getId(), authString);
				permissionVo=new PermissionVo(authRule.getName(),authRule.getUrl(),firstRules);
				lists.add(permissionVo);
			}
		}
		System.out.println(permissionVo);
     	MemberVo memberVo=new MemberVo();
     	memberVo.setUser(MemberVo.getSysuser());
     	memberVo.setRules(lists);

		return memberVo;
	}
}