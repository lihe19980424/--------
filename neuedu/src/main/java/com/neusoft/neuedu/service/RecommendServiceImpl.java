package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.dao.ProductDao;
import com.neusoft.neuedu.dao.RecommendDao;
import com.neusoft.neuedu.entity.Product;
import com.neusoft.neuedu.entity.Recommend;
import com.neusoft.neuedu.entity.User;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private RecommendDao recommendDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public HigherResponse<String> addCommend(HttpSession session, Integer cId) {
		Object attribute = session.getAttribute("userInfo");
		User user = null;
		if(attribute instanceof User) {
			 user = (User)attribute;
		}
		if(null == user) {
			return HigherResponse.getFailedRespon("未登录,请登录后查看");
		}
		Recommend recommend = new Recommend();
		recommend.setUserId(user.getId());
		recommend.setcId(cId);
		// 判断是否有过浏览记录
		Recommend queryRecommend = recommendDao.queryRecommend(recommend);
		if(null == queryRecommend) {
			recommendDao.addOneCommend(recommend);
		}else{
			recommendDao.updateOneCommend(recommend);
		}
		return HigherResponse.getSuccessRespon("添加成功");
	}	
	
	@Override
	public HigherResponse<List<Product>> recommendPro(HttpSession session) {
		Object attribute = session.getAttribute("userInfo");
		User user = null;
		if(attribute instanceof User) {
			 user = (User)attribute;
		}
		if(null == user) {
			return HigherResponse.getFailedRespon("未登录,请登录后查看");
		}
		// 如果没有浏览记录
		Recommend queryUserLookLogByUserId = recommendDao.queryUserLookLogByUserId(user.getId());
		if(null == queryUserLookLogByUserId) {
			List<Product> newProByCId = productDao.getNewProByCId(null);
			return HigherResponse.getSuccessRespon(newProByCId);
		}
		// 如果有浏览记录
		Integer cId = queryUserLookLogByUserId.getcId();
		List<Product> newProByCId = productDao.getNewProByCId(cId);
		return HigherResponse.getSuccessRespon(newProByCId);
	}
}