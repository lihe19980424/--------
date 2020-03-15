package com.neusoft.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Category;
import com.neusoft.neuedu.service.CateService;

@RestController
@RequestMapping("/cate")
public class CateCon {

	@Autowired
	private CateService cateService;
	
	@RequestMapping("/queryCate.do")
	public HigherResponse<PageInfo<Category>> queryCateByPage(HttpSession session,@RequestParam(required = true,defaultValue = "1")Integer pageNum,@RequestParam(required = true,defaultValue = "5")Integer pageSize){
		return cateService.pageByCate(session, pageNum, pageSize);
	}
	
	@RequestMapping("/queryCateName.do")
	public HigherResponse<List<Category>> queryCateByPage(HttpSession session){
		return cateService.getCateName(session);
	}
	
	//添加类别
	@RequestMapping("/addCate.do")
	public HigherResponse<String> addOneCate(HttpSession session,Category category){
		return cateService.addCategory(session, category);
	}
	
	// 修改类别
	@RequestMapping("/updateCate.do")
	public HigherResponse<String> updateCate(HttpSession session,Integer cId,String cName){
		return cateService.updateCategory(session, cId, cName);
	}
	
	// 删除类别
	@RequestMapping("/deleteCate.do")
	public HigherResponse<String> deleteCate(HttpSession session,Integer cId){
		return cateService.deleteCateById(session, cId);
	}
	
}