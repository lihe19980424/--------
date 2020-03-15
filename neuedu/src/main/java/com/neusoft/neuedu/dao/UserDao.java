package com.neusoft.neuedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.neuedu.entity.User;

public interface UserDao {
	
	User queryUser(@Param("username")String username,@Param("psw")String psw);
	
	// 查询用户
	List<User> queryAllUsers();
	
	// 根据id查询用户信息
	User queryUserById(Integer userId);
	
	// 根据id修改用户信息
	int updateUserById(User user);
	
	/*
	 * ========================前台功能===========================
	 */
	
	// 添加用户
	int addOneUser(User user);
	
	
	// 查询手机号是否存在
	User queryUserByPhone(String phone);
	// 查询前台用户是否存在
	User queryLoginUser(@Param("username")String username,@Param("psw")String psw);
}