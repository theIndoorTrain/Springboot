package com.xm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xm.pojo.User;

@RestController
public class UserController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello spring boot!";
	}
	
	@PostMapping("/user")
	public String addUser(@Valid User user) {
		return user.toString();
	}

}
