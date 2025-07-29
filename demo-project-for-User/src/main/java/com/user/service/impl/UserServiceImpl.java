package com.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserRequest;
import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import com.wfm.response.Response;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Response createUser(UserRequest request) {

		// Create a response object
		Response res = new Response();

		// Check if email already exists
		if (userRepository.existsByEmail(request.getEmail())) {
			res.setData(null);
			res.setMessage("User already exists with email: " + request.getEmail());
			res.setResult(false);
			res.setStatus(409);
			return res;
		}

		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setAddress(request.getAddress());
		user.setCity(request.getCity());
		user.setState(request.getState());
		user.setZipCode(request.getZipCode());
		user.setRole(request.getRole());
		User savedUser = userRepository.save(user);

		res.setData(savedUser);
		res.setMessage("User created successfully");
		res.setResult(true);
		res.setStatus(201);
		return res;

	}
}
