package com.neusoft.neuedu.entity.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CollectionShopVo {
	
	public CollectionShopVo() {

	}

	public CollectionShopVo(Integer proId, String pro_name, BigDecimal price, Integer userId, String main_image,
			Byte status) {
		super();
		this.proId = proId;
		this.pro_name = pro_name;
		this.price = price;
		this.userId = userId;
		this.main_image = main_image;
		this.status = status;
	}

	@Override
	public String toString() {
		return "CollectionShopVo [proId=" + proId + ", pro_name=" + pro_name + ", price=" + price + ", userId=" + userId
				+ ", main_image=" + main_image + ", status=" + status + "]";
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMain_image() {
		return main_image;
	}

	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	private Integer proId;
	
	private String pro_name;
	
	private BigDecimal price;
	
	private Integer userId;
	
	private String main_image;
	
	private Byte status;
	
	
}