package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.pojo.pet;
import com.pojo.user;
import com.repository.PetRepository;
import com.utils.Page;
@Service("petService") // 配置业务层的bean

public interface PetService{

	public void addPet(String p_code,String p_family,String p_sex,String p_kind,
			String p_characteristic,String p_province,String p_city,String p_district,
			String p_date,String tt_name,String p_img,String description);
						 
	public void updatePet(String p_code,String p_family,String p_sex,String p_kind,
			String p_characteristic,String p_province,String p_city,String p_district,
			String p_date,String tt_name,String p_img,String description);

	public int deletePet(pet pet);

	public PageInfo<pet> queryPet(Integer page, Integer pageSize);

	public List<pet> findPet(String p_code,String tt_name,String p_kind, String p_sex, String p_characteristic, String p_family,
			String p_province, String p_city, String p_district);






}
