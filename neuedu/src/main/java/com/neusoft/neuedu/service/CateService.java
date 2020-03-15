package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Category;

public interface CateService {

	
	/*
	 * 分页查询所有类别
	 */
	HigherResponse<PageInfo<Category>> pageByCate(HttpSession session,Integer pageNum,Integer pageSize);

	/*
	 * 查询所有类别名
	 */
	HigherResponse<List<Category>> getCateName(HttpSession session);
	
	/**
	 * 添加类别
	 */
	HigherResponse<String> addCategory(HttpSession session,Category category);


	/**
	 * 修改类名
	   先判断类名是否存在 如果存在报错
	   否则修改类名
	 */
	HigherResponse<String> updateCategory(HttpSession session,Integer cId,String cName);
	
	/**
	 * 删除类别
	 * 
	 */
	HigherResponse<String> deleteCateById(HttpSession session,Integer cId);
}