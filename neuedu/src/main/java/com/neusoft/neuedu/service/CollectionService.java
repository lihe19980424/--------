package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Collections;
import com.neusoft.neuedu.entity.vo.CollectionShopVo;

/**
 * 收藏业务层
 * @author Neuedu
 *
 */
public interface CollectionService {

	
	// 添加收藏
	HigherResponse<String> addCollection(HttpSession session,Integer proId);
	
	// 根据用户id查询收藏信息
	HigherResponse<List<CollectionShopVo>> queryCollectByUserId(HttpSession session);
	
}