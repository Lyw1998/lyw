package com.pojo;


import java.io.Serializable;

public class user_role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long user_id;
    private int role_id;
    
	public user_role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "user_role [user_id=" + user_id + ", role_id=" + role_id + "]";
	}
	
	
}
