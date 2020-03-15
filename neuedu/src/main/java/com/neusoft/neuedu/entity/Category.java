package com.neusoft.neuedu.entity;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Category {
	
	public Category() {
		
	}
	
	public Category(Integer id, Integer parent_id, String name, Byte status, Integer sort_order, Timestamp create_time,
			Timestamp update_time, String icon) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.sort_order = sort_order;
		this.create_time = create_time;
		this.update_time = update_time;
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", status=" + status
				+ ", sort_order=" + sort_order + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", icon=" + icon + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getSort_order() {
		return sort_order;
	}

	public void setSort_order(Integer sort_order) {
		this.sort_order = sort_order;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	private Integer id;
	
	private Integer parent_id;
	
	private String name;
	
	private Byte status;
	
	private Integer sort_order;
	
	private Timestamp create_time;
	
	private Timestamp update_time;
	
	private String icon;
	
}