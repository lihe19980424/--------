package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Product;

public interface RecommendService {

	// 添加浏览记录
	public HigherResponse<String> addCommend(HttpSession session,Integer cId);
	
	// 推荐商品
	public HigherResponse<List<Product>> recommendPro(HttpSession session);
	
}