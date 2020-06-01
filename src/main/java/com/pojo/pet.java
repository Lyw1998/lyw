package com.pojo;

import java.sql.Date;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value="classpath:resource.properties")
@Component
public class pet {
	private int p_id;
	private String p_code;
	private String p_kind;
	private String p_sex;
	private String p_characteristic;
	private String p_family;
	private String p_province;
	private String p_city;
	private String p_district;
	private String tt_name;
	private String p_date;
	private String p_img;
	private String description;


	
	public pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_kind() {
		return p_kind;
	}

	public void setP_kind(String p_kind) {
		this.p_kind = p_kind;
	}

	public String getP_sex() {
		return p_sex;
	}

	public void setP_sex(String p_sex) {
		this.p_sex = p_sex;
	}

	public String getP_characteristic() {
		return p_characteristic;
	}

	public void setP_characteristic(String p_characteristic) {
		this.p_characteristic = p_characteristic;
	}

	public String getP_family() {
		return p_family;
	}

	public void setP_family(String p_family) {
		this.p_family = p_family;
	}

	public String getP_province() {
		return p_province;
	}

	public void setP_province(String p_province) {
		this.p_province = p_province;
	}

	public String getP_city() {
		return p_city;
	}

	public void setP_city(String p_city) {
		this.p_city = p_city;
	}

	public String getP_district() {
		return p_district;
	}

	public void setP_district(String p_district) {
		this.p_district = p_district;
	}

	public String getTt_name() {
		return tt_name;
	}

	public void setTt_name(String tt_name) {
		this.tt_name = tt_name;
	}
	
	public String getP_date() {
		return p_date;
	}

	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	
	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "pet [p_id=" + p_id + ", p_code=" + p_code + ", p_kind=" + p_kind + ", p_sex=" + p_sex
				+ ", p_characteristic=" + p_characteristic + ", p_family=" + p_family + ", p_province=" + p_province
				+ ", p_city=" + p_city + ", p_district=" + p_district + ", tt_name=" + tt_name + ", p_date=" + p_date
				+ ", p_img=" + p_img + ", description=" + description + "]";
	}








}
