package com.easybuy.entity;

import java.io.Serializable;

public class UserAddress implements Serializable{
	
	private Integer id;
	private String address;
	private String createTime;
	private Integer userId;
	private Integer isDefault;
	private String remark;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public UserAddress(Integer id, String address, String createTime,
			Integer userId, Integer isDefault, String remark) {
		super();
		this.id = id;
		this.address = address;
		this.createTime = createTime;
		this.userId = userId;
		this.isDefault = isDefault;
		this.remark = remark;
	}
	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", address=" + address
				+ ", createTime=" + createTime + ", userId=" + userId
				+ ", isDefault=" + isDefault + ", remark=" + remark + "]";
	}
	
	
}
