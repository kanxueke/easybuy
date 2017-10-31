package com.easybuy.entity;

import java.io.Serializable;

public class ProductCategory implements Serializable{
	
	private Integer id;
	private String name;
	private Integer parentId;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public ProductCategory(Integer id, String name, Integer parentId,
			Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
	}
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", parentId="
				+ parentId + ", type=" + type + "]";
	}
	
	
	
}
