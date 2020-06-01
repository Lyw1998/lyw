package com.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.pet;
import com.pojo.user;
import com.repository.PetRepository;
import com.repository.UserRepository;
import com.service.PetService;
import com.utils.Page;

@Service("petService")
// 配置业务层的bean
@Transactional
public class PetServiceImpl implements PetService {

	// 声明DAO属性并注入s
	@Autowired
	private PetRepository petRepository;
	//private petDao petdao;

	public PageInfo<pet> queryPet(Integer page, Integer pageSize) {
		 PageHelper.startPage(page,pageSize);//分页起始码以及每页页数
		    List<pet> pets=petRepository.queryPet(); 
		    PageInfo pageInfo=new PageInfo(pets);
		    System.out.println(pageInfo);
		return pageInfo;
	}

	public List<pet> findPet(String p_code,String tt_name,String p_kind, String p_sex, String p_characteristic, String p_family,
			String p_province, String p_city, String p_district) {
		System.out.println("p_code:"+p_code+"	tt_name:"+tt_name+"	p_kind:"+p_kind+"	p_sex:"+p_sex);
		System.out.println("p_characteristic:"+p_characteristic+"	p_family:"+p_family);
		System.out.println("p_province:"+p_province+" p_city:"+p_city+"	p_district:"+p_district);
				return petRepository.findPet(p_code,tt_name,p_kind,p_sex,p_characteristic,p_family,
						p_province,p_city,p_district);
	}

	public void addPet(String p_code, String p_family, String p_sex,
			String p_kind, String p_characteristic, String p_province,
			String p_city, String p_district, String p_date,String tt_name,String p_img,String description) {
		petRepository.addPet(p_code, p_family, p_sex, p_kind, p_characteristic,
				p_province, p_city, p_district, p_date,tt_name,p_img,description);
	}

	public void updatePet(String p_code,String p_family,String p_sex,String p_kind,
		String p_characteristic,String p_province,String p_city,String p_district,String p_date,String tt_name,String p_img,String description) {
		petRepository.updatePet(p_code,p_family,p_sex,p_kind,p_characteristic,
				 p_province,p_city,p_district,p_date,tt_name,p_img,description);
	}

	public int deletePet(pet pet) {
		return petRepository.deletePet(pet);
	}







}
