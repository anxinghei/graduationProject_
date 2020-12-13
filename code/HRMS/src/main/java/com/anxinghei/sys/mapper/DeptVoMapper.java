package com.anxinghei.sys.mapper;



import com.anxinghei.sys.vo.DeptVo;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface DeptVoMapper {
	
	@Select("SELECT d.id as dId,d.simplename as dName,d.description as description,e.id as mId,e.name as mName FROM dept d JOIN employee e ON d.manager = e.id ")
	List<DeptVo> getAllDeptToShow();
}
