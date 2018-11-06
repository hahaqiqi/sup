package com.haha.user.service;

import com.haha.user.entity.User;

import java.util.List;

public interface UserService {
	public User login(String userCode,String userPassword);
}
