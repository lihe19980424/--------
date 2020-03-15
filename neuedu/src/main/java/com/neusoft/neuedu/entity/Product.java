package com.neusoft.neuedu.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	public Product() {
	
	}
	
	public Product(Integer id, Integer category_id, String name, String subtitle, String mainImage, String subImages,
			String detail, BigDecimal price, Short stock, Byte status, Byte isNew, Byte isHot, Byte isBanner,
			Timestamp createTime, Timestamp updateTime) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.subtitle = subtitle;
		this.mainImage = mainImage;
		this.subImages = subImages;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.isNew = isNew;
		this.isHot = isHot;
		this.isBanner = isBanner;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", subtitle=" + subtitle
				+ ", mainImage=" + mainImage + ", subImages=" + subImages + ", detail=" + detail + ", price=" + price
				+ ", stock=" + stock + ", status=" + status + ", isNew=" + isNew + ", isHot=" + isHot + ", isBanner="
				+ isBanner + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSubImages() {
		return subImages;
	}

	public void setSubImages(String subImages) {
		this.subImages = subImages;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Short getStock() {
		return stock;
	}

	public void setStock(Short stock) {
		this.stock = stock;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getIsNew() {
		return isNew;
	}

	public void setIsNew(Byte isNew) {
		this.isNew = isNew;
	}

	public Byte getIsHot() {
		return isHot;
	}

	public void setIsHot(Byte isHot) {
		this.isHot = isHot;
	}

	public Byte getIsBanner() {
		return isBanner;
	}

	public void setIsBanner(Byte isBanner) {
		this.isBanner = isBanner;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	private Integer id;
	
	private Integer category_id;
	
	private String name;
	
	private String subtitle;
	
	private String mainImage;
	
	private String subImages;
	
	private String detail;
	
	private BigDecimal price;
	
	private Short stock;
	
	private Byte status;
	
	private Byte isNew;
	
	private Byte isHot;
	
	private Byte isBanner;
	
	private Timestamp createTime;
	
	private Timestamp updateTime;
}