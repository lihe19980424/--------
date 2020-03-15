package com.neusoft.neuedu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.entity.vo.CollectionShopVo;
import com.neusoft.neuedu.service.CollectionService;

@RestController
@RequestMapping("/coll")
public class CollectionCon {

	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping("/addColl.do")
	public HigherResponse<String> addCollect(HttpSession session,Integer proId){
		return collectionService.addCollection(session, proId);
	}
	
	@RequestMapping("/getCollVo.do")
	public HigherResponse<List<CollectionShopVo>> getCollectionInfos(HttpSession session){
		return collectionService.queryCollectByUserId(session);
	}
}