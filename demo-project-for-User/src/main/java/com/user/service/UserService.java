package com.user.service;


import com.user.dto.UserRequest;
import com.wfm.response.Response;

public interface UserService {
	Response createUser(UserRequest userRequest);
    
}