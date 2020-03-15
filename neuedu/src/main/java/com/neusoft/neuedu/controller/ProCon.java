package com.neusoft.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Product;
import com.neusoft.neuedu.service.ProductService;

@RestController
@RequestMapping("/pro")
public class ProCon {
	
	@Autowired
	private ProductService productService;
	

	@RequestMapping("/list.do")
	public HigherResponse<PageInfo<Product>> getAllPro(HttpSession session,@RequestParam(defaultValue = "1",required = true)Integer pageNum,@RequestParam(defaultValue = "10",required = true)Integer pageSize){
		return productService.getAllProducts(session, pageNum, pageSize);
	}
	
	@RequestMapping("/addPro.do")
	public HigherResponse<String> addOnePro(HttpSession session,Product product,MultipartFile file){
	    System.out.println(product);
		return productService.addOneProduct(session, product, file);
	}
	
	// 修改商品上下架状态
	@RequestMapping("/updatePro.do")
	public HigherResponse<String> updateProStatus(HttpSession session,Integer proId,Byte status){
		return productService.updateProductStatus(session, proId, status);
	}
	// 删除商品
	@RequestMapping("/deletePro.do")
	public HigherResponse<String> deleteProById(HttpSession session,Integer proId){
		return productService.deleteProById(session, proId);
	}
	
	// 根据商品名和日期查询商品
	@RequestMapping("/queryProByDateAndName.do")
	public HigherResponse<PageInfo<Product>> getProByDateAndName(HttpSession session,String beginDate,String endDate,String proName,@RequestParam(defaultValue = "1",required = true)Integer pageNum,@RequestParam(defaultValue = "3",required = true)Integer pageSize){
		return productService.queryProByDateAndName(session, beginDate, endDate, proName, pageNum, pageSize);
	}
	
	// 前台用户查询最新商品
	@RequestMapping("/queryNewPro.do")
	public HigherResponse<List<Product>> getNewPro(HttpSession session){
		return productService.queryNewPro(session);
	}
	
	// 根据ID查询商品信息
	@RequestMapping("/getProductInfo.do")
	public HigherResponse<Product> getProductById(HttpSession session,Integer proId){
		return productService.getProInfo(session, proId);
	}
	
}