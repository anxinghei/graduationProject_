package com.anxinghei.sys.controller;
import com.anxinghei.sys.service.DeptVoService;
import com.anxinghei.sys.vo.DeptVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("dept")
public class DeptController  {

    @Autowired
    private DeptVoService deptVoService;

    @GetMapping("findAll/{start}/{size}")
    PageInfo<DeptVo> findAll(@PathVariable("start") Integer start, @PathVariable("size") Integer size){
        PageHelper.startPage(start,size);
        List<DeptVo> deptVo=deptVoService.findAll();
        PageInfo<DeptVo> pageInfo=new PageInfo<>(deptVo);
        return pageInfo;
    }

    @PutMapping("update")
    public int update(@RequestBody DeptVo deptVo){
        System.out.println("update---"+deptVo);
        return deptVoService.update(deptVo);
    }
    @DeleteMapping("deleteById/{id}")
    public int deleteById(@PathVariable("id")Integer id){
        return deptVoService.deleteById(id);
    }
    @PostMapping("save")
    public int save(@RequestBody DeptVo deptVo){
        System.out.println("add---"+deptVo);
        return deptVoService.save(deptVo);
    }
}