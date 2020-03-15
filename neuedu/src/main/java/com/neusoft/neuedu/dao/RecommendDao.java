package com.neusoft.neuedu.dao;

import com.neusoft.neuedu.entity.Recommend;

public interface RecommendDao {

	// 根据用户ID和CID查询推荐记录
	Recommend  queryRecommend(Recommend recommend);
	
	
	// 添加推荐记录
	int addOneCommend(Recommend recommend);
	
	
	// 修改用户浏览商品的次数
	int updateOneCommend(Recommend recommend);
	
	// 查询用户是否有浏览记录
	Recommend queryUserLookLogByUserId(Integer userId);
	
}