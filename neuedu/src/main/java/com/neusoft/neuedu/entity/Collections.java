package com.neusoft.neuedu.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class Collections {
	
	public Collections() {
		
	}
	
	public Collections(Integer id, Integer userId, Integer proId, Timestamp create_time, Timestamp update_time) {
		super();
		this.id = id;
		this.userId = userId;
		this.proId = proId;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "Collections [id=" + id + ", userId=" + userId + ", proId=" + proId + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	private Integer id;
	
	private Integer userId;
	
	private Integer proId;
	
	private Timestamp create_time;
	
	private Timestamp update_time;
	
}