package com.haha.user.service;

import com.haha.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userService")
public interface UserService {
	public User login(String userCode,String userPassword);

	/**
	 * 根据条件查询用户列表
	 * @param queryUserName
	 * @param queryUserRole
	 * @return
	 */
	public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo, int pageSize);
}
