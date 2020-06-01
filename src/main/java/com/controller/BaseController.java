package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.basedict;
import com.pojo.user;
import com.service.BasedictService;

@RestController
public class BaseController {
	@Autowired
	private BasedictService basedictService;

	@RequestMapping("/selectProvince")
	public List<basedict> selectProvince(Integer dict_id, String dict_item_name) {
		return basedictService.selectProvince(dict_id, dict_item_name);
	}

	@RequestMapping("/selectCity")
	public List<basedict> selectCity(String dict_item_name ,String dict_item_code ){
		  return basedictService.selectCity(dict_item_name,dict_item_code );
		}

	
	  @RequestMapping("/selectDistrict") 
	  public List<basedict> selectDistrict(String dict_item_name ,String dict_item_code ){
		  System.out.println(dict_item_code);
		  return basedictService.selectDistrict(dict_item_name,dict_item_code );
		  }
	 
	@RequestMapping("/selectfamily")
	public List<basedict> selectfamily(Integer dict_id, String dict_item_name) {
		return basedictService.selectfamily(dict_id, dict_item_name);
	}

	@RequestMapping("/selectsex")
	public List<basedict> selectsex(Integer dict_id, String dict_item_name) {
		return basedictService.selectsex(dict_id, dict_item_name);
	}

	@RequestMapping("/selectkind")
	public List<basedict> selectkind(String dict_item_name ,String dict_item_code ) {
		return basedictService.selectkind(dict_item_name,dict_item_code );
	}

	@RequestMapping("/selectcharacteristic")
	public List<basedict> selectcharacteristic(Integer dict_id, String dict_item_name) {
		return basedictService.selectcharacteristic(dict_id, dict_item_name);
	}
}
