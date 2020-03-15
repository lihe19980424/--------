package com.neusoft.neuedu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.neuedu.common.HigherResponse;
import com.neusoft.neuedu.dao.ProductDao;
import com.neusoft.neuedu.entity.Product;
import com.neusoft.neuedu.entity.User;

@Service
public class PrdocutServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public HigherResponse<PageInfo<Product>> getAllProducts(HttpSession session,Integer pageNum,Integer pageSize) {
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Product> queryAllPro = productDao.queryAllPro();
		if(null == queryAllPro) {
			return HigherResponse.getFailedRespon("商品列表为空");
		}
		PageInfo<Product> pageInfo = new PageInfo<Product>(queryAllPro);
		return HigherResponse.getSuccessRespon(pageInfo);
	}
	
	@Override
	public HigherResponse<String> addOneProduct(HttpSession session, Product product, MultipartFile file) {
		// 判断是否登录
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		// 判断文件是否是图片格式
		String originalFilename = file.getOriginalFilename();
		if(!originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".png")) {
			return HigherResponse.getFailedRespon("图片格式不正确");
		}

		String[] imgs = originalFilename.split("\\.");
		// 生成主图的名字  图片的后缀
		UUID uid = UUID.randomUUID();
		String mainImage = uid+"."+imgs[1];
		product.setMainImage(mainImage);
		// 往数据库添加商品信息
		int addOneProduct = productDao.addOneProduct(product);
		
		if(addOneProduct == 0) {
			return HigherResponse.getFailedRespon("添加商品失败");
		}
		
		// 添加商品信息成功之后往虚拟目录里添加图片  注意:图片命名
		try {
			file.transferTo(new File("D:\\eclipse\\YingYong2\\neuedu\\"+mainImage));
		} catch (IllegalStateException e) {
			return HigherResponse.getFailedRespon("上传图片失败");
		} catch (IOException e) {
			return HigherResponse.getFailedRespon("上传图片失败");
		}
		return HigherResponse.getSuccessRespon("上传成功");
	}
	
	@Override
	public HigherResponse<String> updateProductStatus(HttpSession session, Integer productId, Byte status) {
		// 判断是否登录
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		Product product = new Product();
		product.setId(productId);
		product.setStatus(status);
		int updateProductStatus = productDao.updateProductStatus(product);
		if(updateProductStatus == 0)
		{
			return HigherResponse.getFailedRespon("修改状态失败");
		}
		return HigherResponse.getSuccessRespon("修改成功");
	}
	
	@Override
	public HigherResponse<String> deleteProById(HttpSession session, Integer proId) {
		// 判断是否登录
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		int deleteProductById = productDao.deleteProductById(proId);
		if(deleteProductById == 0) {
			return HigherResponse.getFailedRespon("删除失败");
		}
		return HigherResponse.getSuccessRespon("删除成功");
	}
	
	@Override
	public HigherResponse<PageInfo<Product>> queryProByDateAndName(HttpSession session, String beginDate,
			String endDate,String proName, Integer pageNum, Integer pageSize) {
		// 判断是否登录
		Object attribute = session.getAttribute("user");
		if(null == attribute) {
			return HigherResponse.getFailedRespon("未登录,请重新登录");
		}
		PageHelper.startPage(pageNum,pageSize);
		List<Product> productsByDateAndName = productDao.getProductsByDateAndName(beginDate, endDate, proName);
		PageInfo<Product> pageInfo = new PageInfo<Product>(productsByDateAndName);
		if(null == pageInfo) {
			return HigherResponse.getFailedRespon("没有任何商品");
		}
		return HigherResponse.getSuccessRespon(pageInfo);
	}
	
	@Override
	public HigherResponse<List<Product>> queryNewPro(HttpSession session) {
		Object attribute = session.getAttribute("userInfo");
		User user = null;
		if(attribute instanceof User) {
			 user = (User)attribute;
		}
		if(null == user) {
			return HigherResponse.getFailedRespon("未登录,请登录后查看");
		}
		List<Product> newProduct = productDao.getNewProduct();
		if(newProduct.size() == 0) {
			return HigherResponse.getFailedRespon("服务器异常");
		}
		return HigherResponse.getSuccessRespon(newProduct);
	}
	
	@Override
	public HigherResponse<Product> getProInfo(HttpSession session, Integer proId) {
		Object attribute = session.getAttribute("userInfo");
		User user = null;
		if(attribute instanceof User) {
			 user = (User)attribute;
		}
		if(null == user) {
			return HigherResponse.getFailedRespon("未登录,请登录后查看");
		}
		if(null == proId) {
			return HigherResponse.getFailedRespon("商品id为空,服务器错误");
		}
		Product proById = productDao.getProById(proId);
		if(null == proById) {
			return HigherResponse.getFailedRespon("未查询到商品,请重试");
		}
		return HigherResponse.getSuccessRespon(proById);
	}
}