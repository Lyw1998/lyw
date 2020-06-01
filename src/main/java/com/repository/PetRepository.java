package com.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.pet;
import com.pojo.user;
import com.utils.Page;

public interface PetRepository {
	
	
 	
 	@Insert("insert into pet(p_code,p_kind,p_sex,p_characteristic,p_family,p_province,p_city,p_district,p_date,p_img,tt_name,description) values (#{p_code},#{p_kind},#{p_sex},#{p_characteristic},#{p_family},#{p_province},#{p_city},#{p_district},#{p_date},#{p_img},#{tt_name},#{description})")
	public void addPet(String p_code,String p_family,String p_sex,String p_kind,String p_characteristic,
						  String p_province,String p_city,String p_district,String p_date,String tt_name, String p_img,String description);

 	@Update("update pet set p_kind=#{p_kind},p_sex=#{p_sex},p_characteristic=#{p_characteristic},p_family=#{p_family},p_province=#{p_province},p_city=#{p_city},p_district=#{p_district},p_date=#{p_date},p_img=#{p_img},tt_name=#{tt_name},description=#{description} where p_code=#{p_code}")
	public void updatePet(String p_code,String p_family,String p_sex,String p_kind,String p_characteristic,
			  String p_province,String p_city,String p_district,String p_date,String tt_name, String p_img,String description);

	@Delete("DELETE FROM pet WHERE p_code=#{p_code}")
	public int deletePet(pet pet);
	
	
	@Select("select p_code,tt_name,p_img,description,b.dict_item_name p_province,c.dict_item_name p_city,d.dict_item_name p_district,p_date,e.dict_item_name p_family,"
			+ "f.dict_item_name p_kind,g.dict_item_name p_characteristic,h.dict_item_name p_sex from pet a "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '001') b ON a.p_province = b.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '002') c ON a.p_city = c.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '003') d ON a.p_district = d.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '004') e ON a.p_family = e.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '005') f ON a.p_kind = f.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '006') g ON a.p_characteristic = g.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '007') h ON a.p_sex = h.dict_id ")
	@Results(id="petResult",value={		  
			@Result(id=true,column="p_code",property="p_code"),			  
			@Result(column="p_kind",property="p_kind"),
			@Result(column="p_sex",property="p_sex"),  
		    @Result(column="p_characteristic",property="p_characteristic"),
		    @Result(column="p_family",property="p_family"),
		    @Result(column="p_province",property="p_province"),
		    @Result(column="p_city",property="p_city"),
		    @Result(column="p_district",property="p_district"),
		    @Result(column="tt_name",property="tt_name"),
			@Result(column="p_date",property="p_date"),
			@Result(column="p_img",property="p_img"),
			@Result(column="description",property="description")
			})
	public List<pet> queryPet();

	@Select("select p_code,tt_name,p_date,p_img,description,b.dict_item_name p_province,c.dict_item_name p_city,d.dict_item_name p_district,e.dict_item_name p_family,"
			+ "f.dict_item_name p_kind,g.dict_item_name p_characteristic,h.dict_item_name p_sex from pet a "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '001') b ON a.p_province = b.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '002') c ON a.p_city = c.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '003') d ON a.p_district = d.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '004') e ON a.p_family = e.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '005') f ON a.p_kind = f.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '006') g ON a.p_characteristic = g.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '007') h ON a.p_sex = h.dict_id "
			+ "	WHERE p_code LIKE CONCAT(CONCAT('%', #{p_code}, '%')) AND tt_name LIKE CONCAT(CONCAT('%', #{tt_name}, '%'))"
			+ "AND p_kind LIKE CONCAT(CONCAT('%', #{p_kind}, '%')) AND p_sex LIKE CONCAT(CONCAT('%', #{p_sex}, '%'))"
			+" AND p_family LIKE CONCAT(CONCAT('%', #{p_family}, '%')) AND p_characteristic LIKE CONCAT(CONCAT('%', #{p_characteristic}, '%'))"
			+"AND p_province LIKE CONCAT(CONCAT('%', #{p_province}, '%')) AND p_city LIKE CONCAT(CONCAT('%', #{p_city}, '%')) AND p_district LIKE CONCAT(CONCAT('%', #{p_district}, '%')) ")
	@Results(id="findpetResult",value={		  
			@Result(column="p_code",property="p_code"),			  
			@Result(column="p_kind",property="p_kind"),
			@Result(column="p_sex",property="p_sex"),  
		    @Result(column="p_characteristic",property="p_characteristic"),
		    @Result(column="p_family",property="p_family"),
		    @Result(column="p_province",property="p_province"),
		    @Result(column="p_city",property="p_city"),
		    @Result(column="p_district",property="p_district"),
		    @Result(column="tt_name",property="tt_name"),
			@Result(column="p_date",property="p_date"),
			@Result(column="p_img",property="p_img"),
			@Result(column="description",property="description")})
	public List<pet> findPet(String p_code,String tt_name,String p_kind, String p_sex, String p_characteristic, String p_family, String p_province, String p_city, String p_district);
	

}
