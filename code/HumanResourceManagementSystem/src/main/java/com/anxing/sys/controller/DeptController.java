package com.anxing.sys.controller;

import com.anxing.sys.entity.Dept;
import com.anxing.sys.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("getAll/{start}/{size}")
    public PageInfo<Dept> getAllDepts(@PathVariable("start") Integer start,@PathVariable("size") Integer size){
        PageHelper.startPage(start,size);
        List<Dept> deptList=deptService.getDeptList();
        PageInfo<Dept> pageInfo=new PageInfo<>(deptList);
        return pageInfo;
    }

    @RequestMapping("getAll")
    public List<Dept> getAllDept(){
        return deptService.getDeptList();
    }


    @RequestMapping("delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id){
        return deptService.deleteDept(id);
    }
}
