package com.pojo;


import java.io.Serializable;

public class role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
    private String authority;
    
	public role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "role [id=" + id + ", authority=" + authority + "]";
	}
	
}
