package com.anxinghei.sys.service;

import com.anxinghei.sys.entity.Dept;
import com.anxinghei.sys.mapper.DeptMapper;
import com.anxinghei.sys.mapper.DeptVoMapper;
import com.anxinghei.sys.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class DeptVoService {
    @Autowired
    private DeptVoMapper deptVoMapper;
    @Autowired
    private DeptMapper deptMapper;

    public List<DeptVo> findAll(){
        return deptVoMapper.getAllDeptToShow();
    }

    public int update(DeptVo deptVo){
        Dept dept=new Dept();
        dept.setId(deptVo.getdId());
        dept.setSimplename(deptVo.getdName());
        dept.setDescription(deptVo.getDescription());
        return deptMapper.updateByPrimaryKeySelective(dept);
    }

    public int deleteById(Integer id){
        return deptMapper.deleteByPrimaryKey(id);
    }

    public int save(DeptVo deptVo){
        Dept dept=new Dept();
        dept.setName(deptVo.getdName());
        dept.setSimplename(deptVo.getdName());
        dept.setDescription(deptVo.getDescription());
        return deptMapper.insertSelective(dept);
    }
}
