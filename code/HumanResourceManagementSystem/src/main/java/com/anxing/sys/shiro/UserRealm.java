package com.anxing.sys.shiro;

import java.util.Set;

import com.anxing.sys.entity.Permission;
import com.anxing.sys.entity.Role;
import com.anxing.sys.entity.Sysuser;
import com.anxing.sys.mapper.PermissionMapper;
import com.anxing.sys.mapper.RoleMapper;
import com.anxing.sys.mapper.SysuserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;



/**
 * 自定义Realm
 * @author lenovo
 *
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private SysuserMapper memberService;
	@Autowired
	private RoleMapper authGroupService;
	@Autowired
	private PermissionMapper authRuleService;
	
	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权逻辑");
		
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//添加资源的授权字符串
		//info.addStringPermission("user:add");
		
		//到数据库查询当前登录用户的授权字符串
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		Sysuser member = (Sysuser)subject.getPrincipal();
		// 得到当前用户的权限类别
		int typeById =member.getRole();
		Role authGroup=authGroupService.selectByPrimaryKey(typeById);
		// 得到当前用户权限类别的具体权限序列
		String rules=authGroup.getPerm();
		rules=rules.substring(1);
		if (rules!=null || !rules.isEmpty()) {
			// 拆分权限序列，得到具体权限
			String[] ruleStrings=rules.split(",");
			int id;
			Permission authRule;
			String rule;
			for (int i = 0; i < ruleStrings.length; i++) {
				id=Integer.parseInt(ruleStrings[i]);
				authRule=authRuleService.selectByPrimaryKey(id);
				rule=authRule.getPerm();
				info.addStringPermission(rule);
			}
		}
		try {
            //不确定是什么原因导致权限可能会生成一个空值"", 会报错,所以将空值删除
            if (info != null && info.getStringPermissions() != null) {
                Set<String> permissions = info.getStringPermissions();
                for (String permission : permissions) {
                    if (StringUtils.isEmpty(permission)) {
                        permissions.remove(permission);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("移除空值权限出错---"+e.getMessage());
        }

		return info;
	}
	

	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		
		//编写shiro判断逻辑，判断用户名和密码
		//1.判断用户名
		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
		System.out.println("认证里的token:"+token.getUsername()+"--"+token.getPassword());
		Sysuser sysuser=new Sysuser();
		sysuser.setUsername(token.getUsername());
		Sysuser member = memberService.selectOne(sysuser);
		if(member==null){
			//用户名不存在
			return null;//shiro底层会抛出UnKnowAccountException
		}
		if (member.getStatus()==2) {
			return null;
		}
		
		//2.判断密码
		return new SimpleAuthenticationInfo(member,member.getPassword(),"");
	}

}
