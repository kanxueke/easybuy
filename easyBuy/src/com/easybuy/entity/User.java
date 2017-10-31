package com.easybuy.entity;

import java.io.Serializable;


public class User implements Serializable{
	
	private Integer id;
	private String userName;
	private String loginName;
	private String password;
	private Integer sex;
	private String identityCode;
	private String email;
	private String mobile;
	private Integer type;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public User(Integer id, String userName, String loginName, String password,
			Integer sex, String identityCode, String email, String mobile,
			Integer type) {
		super();
		this.id = id;
		this.userName = userName;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.identityCode = identityCode;
		this.email = email;
		this.mobile = mobile;
		this.type = type;
	}
	private User() {
		super();
		System.out.println("无参构造");
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", loginName="
				+ loginName + ", password=" + password + ", sex=" + sex
				+ ", identityCode=" + identityCode + ", email=" + email
				+ ", mobile=" + mobile + ", type=" + type + "]";
	}
}
