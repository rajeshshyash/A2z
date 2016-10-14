package com.a2z.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.a2z.model.User;
import com.a2z.service.UserService;
import com.a2z.to.UserTo;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/userSave/", method = RequestMethod.POST)
	public UserTo userSave(@RequestBody UserTo user, UriComponentsBuilder ucBuilder) {
		UserTo usrTo = userService.saveUser(user);
		userService.autologin(user.getUserName(), user.getPassword());
		return usrTo;
	}

	@RequestMapping(value = "/userGet/", method = RequestMethod.GET)
	public ResponseEntity<List<?>> listAllUsers() {

		List<?> users = (List<?>) userService.findAllUsers();
		//System.out.println("userGet :" + users);

		return new ResponseEntity<List<?>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/userDetails/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<?>> getUserDetailsProfile(@PathVariable("userId") long userId) {
		UserTo uses = new UserTo();
		uses.setUserId(userId);
		// Long userId = uses.getUserId();
		// System.out.println("userId :"+userId);

		//System.out.println("Fetching User with id " + uses.getUserId());

		List<?> user = (List<?>) userService.getUserDetailsProfile(uses.getUserId());

		//System.out.println("getUserDetailsProfile :" + user);

		return new ResponseEntity<List<?>>(user, HttpStatus.OK);
	}

}
