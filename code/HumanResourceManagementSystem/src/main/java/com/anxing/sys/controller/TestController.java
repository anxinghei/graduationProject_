package com.anxing.sys.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anxing.sys.entity.User;

@RestController
public class TestController {

	@RequestMapping("test")
	public String test() {
		return "success";
	}
	
	@PostMapping("post")
	public String PostMapping(Integer id) {
		return "Post id OK";
	}
	@PostMapping("postBody")
	public String postBody(@RequestBody User user) {
		return "postBody id OK";
	}
	
	@PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        // 如果有参数校验失败，会将错误信息封装成对象组装在BindingResult里
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return "OK";
    }
}
