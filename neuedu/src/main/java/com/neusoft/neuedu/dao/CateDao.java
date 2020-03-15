package com.neusoft.neuedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.neuedu.entity.Category;

/**
 * 类别Dao
 * @author Neuedu
 *
 */
public interface CateDao {

	List<Category> getAllCate();
	
	int addOneCate(Category category);
	

	// 查询类名是否存在
	Category queryCateIsExists(@Param("name")String cateName);
	
	// 修改类名
	// map   key --> value
	int updateCategoryById(@Param(value = "cname")String cateName,@Param(value = "cid")Integer cId);
	
	// 判断类下有没有子类 判断parent_id 有没有包含此类的id
	List<Category> queryCateIsContainChildCate(Integer cId);
	
	// 删除类别
	int deleteCateById(Integer cId);
}