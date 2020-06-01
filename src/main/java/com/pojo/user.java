package com.pojo;

import java.util.List;

public class user {
	private int id;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String province;
	private String city;
	private String district;
	private String jglb;
	private String picture;
	private String state;
    private List<role> roles;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getJglb() {
		return jglb;
	}
	public void setJglb(String jglb) {
		this.jglb = jglb;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<role> getRoles() {
		return roles;
	}
	public void setRoles(List<role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", address=" + address + " province=" + province + ", city=" + city + ", district=" + district + ", picture="
				+ picture + ", state=" + state + ", roles=" + roles + "]";
	}

	
	
}
