package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.dao.CateDao;
import com.neusoft.neuedu.dao.ProductDao;
import com.neusoft.neuedu.entity.Category;
import com.neusoft.neuedu.entity.Product;

@Service
public class CateServiceImpl implements CateService {

	@Autowired
	private CateDao cateDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public HigherResponse<PageInfo<Category>> pageByCate(HttpSession session, Integer pageNum, Integer pageSize) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		PageHelper.startPage(pageNum,pageSize);
		List<Category> allCate = cateDao.getAllCate();
		PageInfo<Category> pageInfo = new PageInfo<Category>(allCate);
		return HigherResponse.getSuccessRespon(pageInfo);
	}
	
	@Override
	public HigherResponse<List<Category>> getCateName(HttpSession session) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		return HigherResponse.getSuccessRespon(cateDao.getAllCate());
	}
	
	@Override
	public HigherResponse<String> addCategory(HttpSession session, Category category) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		if(category.getName().equals("") || category.getName() == null) {
			return HigherResponse.getFailedRespon("类别名不能为空");
		}
		int addOneCate = cateDao.addOneCate(category);
		if(addOneCate == 0) {
			return HigherResponse.getFailedRespon("添加失败");
		}
		return HigherResponse.getSuccessRespon("添加成功");
	}
	
	@Override
	public HigherResponse<String> updateCategory(HttpSession session, Integer cId, String cName) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		if(null == cName || "".equals(cName)) {
			return HigherResponse.getFailedRespon("类名不能为空");
		}
		// 判断类名是否存在
		Category queryCateIsExists = cateDao.queryCateIsExists(cName);
		if(null != queryCateIsExists) {
			return HigherResponse.getFailedRespon("类名重复,请确认");
		}
		// 不存在执行修改
		int updateCategoryById = cateDao.updateCategoryById(cName, cId);
		if(updateCategoryById == 0) {
			return HigherResponse.getFailedRespon("修改失败");
		}
		return HigherResponse.getSuccessRespon("修改成功");
	}
	
	@Override
	public HigherResponse<String> deleteCateById(HttpSession session,Integer cId) {
		System.out.println("cId"+cId);
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		// 先判断是否有子类
		List<Category> queryCateIsContainChildCate = cateDao.queryCateIsContainChildCate(cId);
		
		System.out.println(queryCateIsContainChildCate == null);
		System.out.println("jihe"+queryCateIsContainChildCate);
		
		if(queryCateIsContainChildCate.size() > 0) {
			return HigherResponse.getFailedRespon("不可以删除,请在删除子类后操作");
		}
		// 判断是否有商品
		List<Product> productByCateId = productDao.getProductByCateId(cId);
		if(productByCateId.size() > 0) {
			return HigherResponse.getFailedRespon("不可以删除,请在删除相对应的商品后操作");
		}
		// 执行删除
		int deleteCateById = cateDao.deleteCateById(cId);
		
		System.out.println(deleteCateById);
		
		if(1 == deleteCateById) {
			return HigherResponse.getSuccessRespon("成功删除");
		}
		return HigherResponse.getFailedRespon("删除失败,请重试");
	}
}
