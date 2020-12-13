package com.anxinghei.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.anxinghei.sys.entity.Permission;
import tk.mybatis.mapper.common.Mapper;

/**
 * 权限表
 * 
 * @author Autumn
 * @email 
 * @date 2020-04-01 23:27:40
 */
@org.apache.ibatis.annotations.Mapper
public interface PermissionMapper extends Mapper<Permission> {
	
	@Select("select * from permission where pid= #{pid} and id in (${ruleList})")
	public List<Permission> getPermissionsByUser(Integer pid,String ruleList);
}
