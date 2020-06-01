package com.repository;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pojo.basedict;


public interface BasedictRepository {
	/*
	 * @Select("select * from base_dict where dict_type_code = #{dict_type_code}")
	 * public List<basedict> findBasedictByTypeCode(String dict_type_code);
	 */
		@Select("SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code ='001'")
		public List<basedict> selectProvince(Integer dict_id,String dict_item_name);
		
		@Select("SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code ='002' and dict_item_code=#{dict_item_code}")
		public List<basedict> selectCity(String dict_item_name,String dict_item_code);

	  @Select("SELECT dict_id,dict_item_name FROM base_dict  WHERE dict_type_code ='003' and dict_item_code=#{dict_item_code}" )
	  public List<basedict> selectDistrict(String dict_item_name,String dict_item_code);
	 
	 
		
		
		@Select("SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code ='004'")
		public List<basedict> selectfamily(Integer dict_id,String dict_item_name);
		
		@Select("SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code ='005' and dict_item_code=#{dict_item_code}")
		public List<basedict> selectkind(String dict_item_name ,String dict_item_code );
		
		@Select("SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code ='006'")
		public List<basedict> selectcharacteristic(Integer dict_id,String dict_item_name);
		
		@Select("SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code ='007'")
		public List<basedict> selectsex(Integer dict_id,String dict_item_name);
		
		
		

		
}
