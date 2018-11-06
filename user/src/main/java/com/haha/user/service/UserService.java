package com.haha.user.service;

import com.haha.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userService")
public interface UserService {
	public User login(String userCode,String userPassword);
}
