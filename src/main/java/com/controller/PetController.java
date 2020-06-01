package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.pojo.pet;
import com.pojo.user;
import com.service.BasedictService;
import com.service.PetService;
import com.utils.Page;

@Component
@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService petService;
	@Autowired
	private BasedictService basedictService;

	@RequestMapping("/addPet")
	public void addPet(String code, String family, String sex, String kind, String characteristic, String province,
			String city, String district, String date, String name, String img,String description) {

		petService.addPet(code, family, sex, kind, characteristic, province, city, district, date, name, img,description);
	}

	/*
	 * @RequestMapping("/findAllPet") public Page<pet> findAllPet(Pageable page) {
	 * return petService.findAllPet(page); }
	 */

	@RequestMapping("/queryPet")
	public PageInfo<pet> queryPet(@RequestParam(value="page",defaultValue="1")Integer page,
			  @RequestParam(value="pageSize",defaultValue="5")Integer pageSize,Model model) {
	    PageInfo<pet> pageinfo=petService.queryPet(page, pageSize);
	    return pageinfo;
	}

	@RequestMapping("/findPet")
	@ResponseBody
	public List<pet> findPet(String p_code, String tt_name, String p_kind, String p_sex, String p_characteristic,
			String p_family, String p_province, String p_city, String p_district,String date, String name, String img,String description) {
		System.out.println("p_code:" + p_code + "	tt_name:" + tt_name + "	p_kind:" + p_kind + "	p_sex:" + p_sex);
		System.out.println("p_characteristic:" + p_characteristic + "	p_family:" + p_family);
		System.out.println("p_province:" + p_province + " p_city" + p_city + "	p_district" + p_district);
		return petService.findPet(p_code, tt_name, p_kind, p_sex, p_characteristic, p_family, p_province, p_city,
				p_district);
	}

	@RequestMapping("/updatePet")
	public void updatePet(String code, String family, String sex, String kind, String characteristic, String province,
			String city, String district,String date, String name, String img,String description) {
		petService.updatePet(code, family, sex, kind, characteristic, province, city, district,date, name, img,description);
	}

	@RequestMapping(value="/deletePet")
	public void deletePet(pet pet) {
		petService.deletePet(pet);
	
	}




}
