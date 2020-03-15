package com.neusoft.neuedu.dao;

import java.util.List;

import com.neusoft.neuedu.entity.Collections;
import com.neusoft.neuedu.entity.vo.CollectionShopVo;

public interface CollectionDao {

	// 添加收藏
	public int addOneCoolection(Collections collection);
	
	
	// 查询是否收藏
	public Collections queryCollectionIsExists(Collections collection);
	
	// 查询用户收藏信息
	public List<CollectionShopVo> queryCollectByUserId(Integer userId);

}