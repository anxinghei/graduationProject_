package com.anxinghei.sys.controller;

import com.anxinghei.sys.service.EmployeeVoService;
import com.anxinghei.sys.vo.EmployeeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeVoService employeeVoService;

    @GetMapping("findAll/{start}/{size}")
    PageInfo<EmployeeVo> findAll(@PathVariable("start") Integer start, @PathVariable("size") Integer size){
        PageHelper.startPage(start,size);
        List<EmployeeVo> employeeVo=employeeVoService.findAll();
        PageInfo<EmployeeVo> pageInfo=new PageInfo<>(employeeVo);
        return pageInfo;
    }

    @PutMapping("update")
    public int update(@RequestBody EmployeeVo employeeVo){
        System.out.println("update---"+employeeVo);
        return employeeVoService.update(employeeVo);
    }

    @DeleteMapping("deleteById/{id}")
    public int deleteById(@PathVariable("id")Integer id){
        return employeeVoService.deleteById(id);
    }
}
