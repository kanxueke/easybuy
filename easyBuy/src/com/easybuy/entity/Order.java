package com.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	
	private Integer id;
	private Integer userId;
	private String loginName;
	private String userAddress;
	private Date createTime;
	private Float cost;
	private Integer status;
	private Integer type;
	private String serialNumber;
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Order(Integer id, Integer userId, String loginName,
			String userAddress, Date createTime, Float cost, Integer status,
			Integer type, String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.type = type;
		this.serialNumber = serialNumber;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", loginName="
				+ loginName + ", userAddress=" + userAddress + ", createTime="
				+ createTime + ", cost=" + cost + ", status=" + status
				+ ", type=" + type + ", serialNumber=" + serialNumber + "]";
	}
	
	
}
