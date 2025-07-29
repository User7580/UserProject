package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserRequest;
import com.user.service.UserService;
import com.wfm.response.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/addUsers")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public Response createUser(@Valid @RequestBody UserRequest userRequest) {
	    return userService.createUser(userRequest);
	}
}