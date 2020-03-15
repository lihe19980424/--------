package com.neusoft.neuedu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Product;

public interface ProductService {

	HigherResponse<PageInfo<Product>> getAllProducts(HttpSession session,Integer pageNum,Integer pageSize);
	
	HigherResponse<String> addOneProduct(HttpSession session,Product product,MultipartFile file);
	
	HigherResponse<String> updateProductStatus(HttpSession session,Integer productId,Byte status);
	
	HigherResponse<String> deleteProById(HttpSession session,Integer proId);
	
	HigherResponse<PageInfo<Product>> queryProByDateAndName(HttpSession session,String beginDate,String endDate,String proName,Integer pageNum,Integer pageSize);


	// 前台查询最新商品
	HigherResponse<List<Product>> queryNewPro(HttpSession session);

	// 前台根据id查看商品详情
	HigherResponse<Product> getProInfo(HttpSession session,Integer proId);
	
}