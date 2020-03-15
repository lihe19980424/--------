package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.dao.CollectionDao;
import com.neusoft.neuedu.entity.Collections;
import com.neusoft.neuedu.entity.User;
import com.neusoft.neuedu.entity.vo.CollectionShopVo;

@Service
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	private CollectionDao collectionDao;
	
	
	@Override
	public HigherResponse<String> addCollection(HttpSession session,Integer proId) {
		Object attribute = session.getAttribute("userInfo");
		User user = null;
		if(attribute instanceof User) {
			 user = (User)attribute;
		}
		if(null == user) {
			return HigherResponse.getFailedRespon("未登录,请登录后查看");
		}
		if(null == proId) {
			return HigherResponse.getFailedRespon("商品id为空");
		}
		// 查询收藏里有没有
		Collections collection = new Collections();
		collection.setUserId(user.getId());
		collection.setProId(proId);
		Collections queryCollectionIsExists = collectionDao.queryCollectionIsExists(collection);
		if(null != queryCollectionIsExists) {
			return HigherResponse.getFailedRespon("您已收藏过该商品");
		}
		// 添加收藏
		int addOneCoolection = collectionDao.addOneCoolection(collection);
		if(0 == addOneCoolection) {
			return HigherResponse.getFailedRespon("添加失败...");
		}
		return HigherResponse.getSuccessRespon("添加成功");
	}
	
	@Override
	public HigherResponse<List<CollectionShopVo>> queryCollectByUserId(HttpSession session) {
		Object attribute = session.getAttribute("userInfo");
		User user = null;
		if(attribute instanceof User) {
			 user = (User)attribute;
		}
		if(null == user) {
			return HigherResponse.getFailedRespon("未登录,请登录后查看");
		}
		List<CollectionShopVo> queryCollectByUserId = collectionDao.queryCollectByUserId(user.getId());
		if(queryCollectByUserId.size() == 0) {
			return HigherResponse.getFailedRespon("您还没有收藏信息");
		}
		return HigherResponse.getSuccessRespon(queryCollectByUserId);
	}

}
