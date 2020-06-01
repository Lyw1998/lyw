package com.service;
import java.util.List;

import com.pojo.basedict;
import com.pojo.user;
/**
 * 数据字典Service接口
 */
public interface BasedictService {
	//根据类别代码查询数据字典

	public List<basedict> selectProvince(Integer dict_id,String dict_item_name);

	public List<basedict> selectCity(String dict_item_name ,String dict_item_code);

	public List<basedict> selectDistrict(String dict_item_name ,String dict_item_code );

	public List<basedict> selectfamily(Integer dict_id,String dict_item_name);
	
	public List<basedict> selectkind(String dict_item_name ,String dict_item_code);
	
	public List<basedict> selectcharacteristic(Integer dict_id,String dict_item_name);
	
	public List<basedict> selectsex(Integer dict_id,String dict_item_name);
	

	
}
