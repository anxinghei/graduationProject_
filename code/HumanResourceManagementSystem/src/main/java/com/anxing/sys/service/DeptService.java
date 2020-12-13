package com.anxing.sys.service;

import com.anxing.sys.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anxing.sys.mapper.DeptMapper;

import java.util.List;
//import com.github.wxiaoqi.security.common.biz.BaseBiz;

/**
 * 部门表
 *
 * @author CBA
 * @email 
 * @date 2020-12-10 19:50:03
 */
//public class DeptBiz extends BaseBiz<DeptMapper,Dept> {
//}
@Service
public class DeptService  {
    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> getDeptList(){
        return deptMapper.selectAll();
    }
    public int deleteDept(Integer id){
        if (id==null || id==0)
            return 0;
        return deptMapper.deleteByPrimaryKey(id);
    }
}
