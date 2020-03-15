package com.neusoft.neuedu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.neuedu.entity.Product;

/**
 * 商品接口
 * @author Neuedu
 *
 */
public interface ProductDao {

	List<Product> queryAllPro();
	
	//添加商品
	int addOneProduct(Product product);
	
	//修改商品状态
	int updateProductStatus(Product product);
	
	// 删除商品
	int deleteProductById(Integer proId);
	
	// 根据日期和商品名查询商品
	List<Product> getProductsByDateAndName(@Param(value = "beginDate")String beginDate,@Param(value = "endDate")String endDate,@Param(value = "proName")String proName);

	// 根据类别id查询商品
	List<Product> getProductByCateId(Integer cId);
	
	
	// 前台查询最新商品
	List<Product> getNewProduct();
	
	// 前台根据id查询商品信息
	Product getProById(Integer proId);
	
	// 前台推荐根据类别id查询最新的商品
	List<Product> getNewProByCId(@Param("cId")Integer cId);
}