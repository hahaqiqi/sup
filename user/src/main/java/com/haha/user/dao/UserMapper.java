package com.haha.user.dao;

import com.haha.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user);

	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param(value = "userCode") String userCode, @Param(value = "userPassword") String userPassword);

	/**
	 * 通过条件查询-userList
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(@Param(value = "userName") String userName, @Param(value = "userRole") int userRole, @Param(value = "currentPageNo") int currentPageNo, @Param(value = "pageSize") int pageSize);
	/**
	 * 通过条件查询-用户表记录数
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public int getUserCount(@Param(value = "userName") String userName, @Param(value = "userRole") int userRole);

	/**
	 * 通过userId删除user
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(@Param(value = "delId") Integer delId);


	/**
	 * 通过userId获取user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserById(@Param(value = "id") String id);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modify(User user);


	/**
	 * 修改当前用户密码
	 * @param id
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public int updatePwd(@Param(value = "id") int id, @Param(value = "pwd") String pwd);

	/**
	 * userCode是否可用
	 * @param userCode
	 * @return USer
	 */
	public User selectUserCodeExist(@Param(value = "userCode") String userCode);
}
