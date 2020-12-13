package com.anxinghei.sys.mapper;

import com.anxinghei.sys.vo.EmployeeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeVoMapper {

    @Select("select e.id as id,e.name as name,e.position as pid,p.name as pName,e.startyear as startyear,e.startmonth as startmonth," +
            "e.salary as salary,e.tel as tel,e.department as did,d.simplename as dName" +
            " from employee e,dept d,position p where e.department=d.id and e.position=p.id group by d.id ")
    public List<EmployeeVo> getAllEmployeeToShow();
}
