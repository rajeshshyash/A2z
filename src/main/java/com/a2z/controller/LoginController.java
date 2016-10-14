package com.a2z.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.a2z.service.UserService;
import com.a2z.to.UserTo;

@RestController
public class LoginController {

	@Autowired
	private UserService usersService;

	@RequestMapping(value = "/userLogin/", method = RequestMethod.POST)
	public UserTo userLogin(@RequestBody UserTo user, UriComponentsBuilder ucBuilder) {
		// System.out.println("UserName : "+user.getUserName()+" "+"UserPassword
		// : "+user.getPassword());
		UserTo userdata = usersService.validateUser(user.getUserName(), user.getPassword());
		return userdata;
	}

}