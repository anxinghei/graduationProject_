package com.anxinghei.sys.service;

import com.anxinghei.sys.entity.Employee;
import com.anxinghei.sys.mapper.EmployeeMapper;
import com.anxinghei.sys.mapper.EmployeeVoMapper;
import com.anxinghei.sys.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeVoService {

    @Autowired
    private EmployeeVoMapper employeeVoMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeVo> findAll(){
        return employeeVoMapper.getAllEmployeeToShow();
    }

    public int update(EmployeeVo employeeVo){
        Employee employee=new Employee();
        employee.setId(employeeVo.getId());
        employee.setPosition(employeeVo.getPid());
        employee.setTel(employeeVo.getTel());
        employee.setDepartment(employeeVo.getDid());
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int deleteById(Integer id){
        return employeeMapper.deleteByPrimaryKey(id);
    }
}
