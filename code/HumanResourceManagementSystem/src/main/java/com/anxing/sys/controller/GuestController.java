package com.anxing.sys.controller;

import com.anxing.sys.entity.Guest;
import com.anxing.sys.mapper.GuestMapper;
//import com.github.wxiaoqi.security.common.rest.BaseController;
//import com.anxinghei.sys.biz.GuestBiz;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// extends BaseController<GuestBiz,Guest>

@RestController
@RequestMapping("guest")
public class GuestController  {
	
	@Autowired
	private GuestMapper guestMapper;

	@GetMapping("findAll/{start}/{size}")
	PageInfo<Guest> findAll(@PathVariable("start") Integer start,@PathVariable("size") Integer size){
		PageHelper.startPage(start,size);
		List<Guest> guests=guestMapper.selectAll();
		PageInfo<Guest> pageInfo=new PageInfo<Guest>(guests);	
		return pageInfo;
	}
}