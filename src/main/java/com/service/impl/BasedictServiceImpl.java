package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pojo.basedict;
import com.pojo.user;
import com.repository.BasedictRepository;
import com.repository.UserRepository;
import com.service.BasedictService;
/**
 * 数据字典Service接口实现类
 */
@Service("basedictService")
public class BasedictServiceImpl implements BasedictService{
	
	@Autowired
	private BasedictRepository basedictRepository;
	
	public List<basedict> selectProvince(Integer dict_id,String dict_item_name){
		return basedictRepository.selectProvince(dict_id,dict_item_name);
	}
	
	public List<basedict> selectCity(String dict_item_name,String dict_item_code){
		System.out.println(dict_item_code);
		return basedictRepository.selectCity(dict_item_name,dict_item_code);
	}


	  public List<basedict> selectDistrict(String dict_item_name,String dict_item_code){
	  System.out.println(dict_item_code);
	  return basedictRepository.selectDistrict(dict_item_name,dict_item_code); }
	 
	
	public List<basedict> selectfamily(Integer dict_id,String dict_item_name){
		return basedictRepository.selectfamily(dict_id,dict_item_name);
	}
	
	public List<basedict> selectkind(String dict_item_name ,String dict_item_code ){
		return basedictRepository.selectkind(dict_item_name ,dict_item_code );
	}
	
	public List<basedict> selectcharacteristic(Integer dict_id,String dict_item_name){
		return basedictRepository.selectcharacteristic(dict_id,dict_item_name);
	}
	
	public List<basedict> selectsex(Integer dict_id,String dict_item_name){
		return basedictRepository.selectsex(dict_id,dict_item_name);
	}
	
	
}
