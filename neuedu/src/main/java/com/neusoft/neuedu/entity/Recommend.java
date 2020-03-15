package com.neusoft.neuedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Recommend {
	
	public Recommend() {

	}
	
	public Recommend(Integer userId, Integer cId, Integer num) {
		super();
		this.userId = userId;
		this.cId = cId;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Recommend [userId=" + userId + ", cId=" + cId + ", num=" + num + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	private Integer userId;
	
	private Integer cId;
	
	private Integer num;
	
}