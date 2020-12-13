package com.anxinghei.sys.service;

import com.anxinghei.sys.mapper.EmployeeVoMapper;
import com.anxinghei.sys.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeVoService {

    @Autowired
    private EmployeeVoMapper employeeVoMapper;

    public List<EmployeeVo> findAll(){
        return employeeVoMapper.getAllEmployeeToShow();
    }
}
