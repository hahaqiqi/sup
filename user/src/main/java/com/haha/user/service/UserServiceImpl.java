package com.haha.user.service;

import com.haha.user.dao.UserMapper;
import com.haha.user.emums.ResultEnum;
import com.haha.user.entity.User;
import com.haha.user.exception.UserException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	public UserMapper userMapper;

	@Override
	public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
		return userMapper.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
	}

	@Override
	public User login(String userCode, String userPassword) {
		User user=userMapper.getLoginUser(userCode,userPassword);
		if(null==user){
			throw new UserException(ResultEnum.USER_ERROR);
		}
		return user;
	}
}
