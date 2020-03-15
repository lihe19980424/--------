package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.dao.UserDao;
import com.neusoft.neuedu.entity.User;
import com.neusoft.neuedu.util.MsgUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public HigherResponse<User> login(String username, String psw,HttpServletRequest req) {
		User user = userDao.queryUser(username, psw);
		if(user == null) {
			return HigherResponse.getFailedRespon("用户名或密码错误");
		}
		req.getSession().setAttribute("user", user);
		return HigherResponse.getSuccessRespon(user);
	}
	
	@Override
	public HigherResponse<PageInfo<User>> queryUserByPage(Integer pageNum, Integer pageSize,HttpServletRequest req) {
		User attribute = (User)req.getSession().getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登陆,请登录后执行");
		}
		// 开启分页插件
		PageHelper.startPage(pageNum, pageSize);
		// 查询用户
		List<User> queryAllUsers = userDao.queryAllUsers();
		PageInfo<User> pageInfo = new PageInfo<User>(queryAllUsers);
		return HigherResponse.getSuccessRespon(pageInfo);
	}

	@Override
	public HigherResponse<User> getLoginUserInfo(HttpSession session) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		if(attribute instanceof User) {
			User user = (User)attribute;
			return HigherResponse.getSuccessRespon(user);
		}
		return HigherResponse.getFailedRespon("服务器异常");
	}
	
	@Override
	public HigherResponse<User> getUserInfoByUserId(HttpSession session, Integer id) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		User queryUserById = userDao.queryUserById(id);
		if(null == queryUserById) {
			return HigherResponse.getFailedRespon("服务器异常");
		}
		return HigherResponse.getSuccessRespon(queryUserById);
	}
	
	
	@Override
	public HigherResponse<String> updateUserInfoById(HttpSession session, User user) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		int updateUserById = userDao.updateUserById(user);
		if(0 == updateUserById) {
			return HigherResponse.getFailedRespon("修改失败");
		}
		return HigherResponse.getSuccessRespon("修改成功");
	}
	
	
	/*=========================前台*/
	
	@Override
	public HigherResponse<String> registerUser(User user) {
		int addOneUser = userDao.addOneUser(user);
		if(addOneUser == 0) {
			return HigherResponse.getFailedRespon("注册失败");
		}
		return HigherResponse.getSuccessRespon("注册成功");
	}

	@Override
	public HigherResponse<String> sendCode(String phone) {
		// 判断手机号是否存在
		User queryUserByPhone = userDao.queryUserByPhone(phone);
		
		System.out.println(queryUserByPhone);
		
		if(null != queryUserByPhone) {
			return HigherResponse.getFailedRespon("该手机号已注册,请重新注册");
		}
		// 发送验证码
		String code = MsgUtils.getCode(phone);
		return HigherResponse.getSuccessRespon("success,"+code);
	}
	
	@Override
	public HigherResponse<User> loginUser(HttpSession session,String username, String psw) {
		User queryLoginUser = userDao.queryLoginUser(username, psw);
		if(null == queryLoginUser) {
			return HigherResponse.getFailedRespon("不存在这个账户");
		}
		// 把用户信息添加到session
		session.setAttribute("userInfo", queryLoginUser);
		return HigherResponse.getSuccessRespon(queryLoginUser);
	}
	
}
   