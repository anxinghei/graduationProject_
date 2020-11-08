package com.anxing.sys.controller;

import com.anxing.sys.entity.Guest;
import com.anxing.sys.mapper.GuestMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.github.yedaxia.apidocs.ApiDoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 */
@RequestMapping("guest")
@RestController
public class GuestController  {
	
	@Autowired
	private GuestMapper guestMapper;

	/**
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	@GetMapping("findAll/{start}/{size}")
	public PageInfo<Guest> findAll(@PathVariable("start") Integer start,@PathVariable("size") Integer size){
		PageHelper.startPage(start,size);
		List<Guest> guests=guestMapper.selectAll();
		PageInfo<Guest> pageInfo=new PageInfo<Guest>(guests);	
		return pageInfo;
	}
}