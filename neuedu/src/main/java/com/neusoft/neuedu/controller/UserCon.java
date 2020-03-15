package com.neusoft.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.User;
import com.neusoft.neuedu.service.UserService;

@RestController
public class UserCon {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/query.do")
	public HigherResponse<User> queryUser(String username,String psw,HttpServletRequest  req){
		return userService.login(username, psw,req);
	}
	
	// 分页查询用户
	@RequestMapping("/queryUserByPage.do")
	public HigherResponse<PageInfo<User>> queryUserByPage(@RequestParam(required = true,defaultValue = "1")Integer pageNum,@RequestParam(required = true,defaultValue = "2")Integer pageSize,HttpServletRequest req){
			return userService.queryUserByPage(pageNum, pageSize, req);
	}
	// 获取登录用户信息接口
	@RequestMapping("/get_user_info.do")
	public HigherResponse<User> getLoginUserInfo(HttpSession session){
		return userService.getLoginUserInfo(session);
	}
	
	// 根据用户ID查询用户信息
	@RequestMapping("/get_userInfoById.do")
	public HigherResponse<User> getUserInfoByUserId(Integer id,HttpSession session){
		return userService.getUserInfoByUserId(session, id);
	}
	
	// 根据用户id修改用户信息
	@RequestMapping("/updateUserInfo.do")
	public HigherResponse<String> updateUserInfoById(HttpSession session,HttpServletRequest req,User user){
		String ip = req.getRemoteAddr();
		user.setIp(ip);
		System.out.println("user"+user);
		return userService.updateUserInfoById(session, user);
	}
	
	// 前台注册用户
	@RequestMapping("/add.do")
	public HigherResponse<String> registerUser(User user){
		return userService.registerUser(user);
	}
	
	// 前台注册用户发送验证码
	@RequestMapping("/sendCode.do")
	public HigherResponse<String> sendCode(String phone){
		return userService.sendCode(phone);
	}
	
	// 前台用户发送验证码登录
	@RequestMapping("/login.do")
	public HigherResponse<User> loginUser(HttpSession session,String username,String password){
		return userService.loginUser(session,username, password);
	}
	
}