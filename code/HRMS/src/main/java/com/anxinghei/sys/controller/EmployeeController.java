package com.anxinghei.sys.controller;

import com.anxinghei.sys.entity.Employee;
import com.anxinghei.sys.service.EmployeeVoService;
import com.anxinghei.sys.vo.EmployeeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeVoService employeeVoService;

    @GetMapping("findAll/{start}/{size}")
    PageInfo<EmployeeVo> findAll(@PathVariable("start") Integer start, @PathVariable("size") Integer size){
        PageHelper.startPage(start,size);
        List<EmployeeVo> deptVo=employeeVoService.findAll();
        PageInfo<EmployeeVo> pageInfo=new PageInfo<>(deptVo);
        return pageInfo;
    }
}
