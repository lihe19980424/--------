package com.neusoft.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.Product;
import com.neusoft.neuedu.service.RecommendService;

@RestController
@RequestMapping("/log")
public class RecommendCon {

	@Autowired
	private RecommendService recommendService;
	
	@RequestMapping("/addComm.do")
	public HigherResponse<String> addRecommend(HttpSession session,Integer cId){
		return recommendService.addCommend(session, cId);
	}
	
	@RequestMapping("/comm.do")
	public HigherResponse<List<Product>> recommend(HttpSession session){
		return recommendService.recommendPro(session);
	}
	
}