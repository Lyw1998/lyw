package com.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.userdetails.User;

import com.pojo.pet;
import com.pojo.user;
import com.pojo.user_role;
import com.utils.Page;

public interface UserRepository {
	  @Insert("insert into user(username,password,name,phone,state,authority)"+
			  "values (#{username},#{password},#{name},#{phone},30,'ROLE_GT')")
			  public int gt_register(user user);
	  @Insert("insert into user_role(role_id) values (2)")
		public int gt_register_role(user_role user_role);
	
	  @Insert("insert into user(username,password,name,phone,province,city,district,address,picture,state,authority)"+
	  "values (#{username},#{password},#{name},#{phone},#{province},#{city},#{district},#{address},#{picture},29,'ROLE_TT')")
	  public int tt_register(user user);
	  @Insert("insert into user_role(role_id) values (3)")
	  public int tt_register_role(user_role user_role);
	  	
	@Select("select id,username,name,phone,address,b.dict_item_name province,c.dict_item_name city,d.dict_item_name district,picture,e.dict_item_name state,f.dict_item_name jglb from user a "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '001') b ON a.province = b.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '002') c ON a.city = c.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '003') d ON a.district = d.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '008') e ON a.state = e.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '009') f ON a.jglb = f.dict_id ")
	@Results(id="userResult",value={		  		  
			@Result(column="username",property="username"),
			@Result(column="name",property="name"),  
		    @Result(column="phone",property="phone"),
		    @Result(column="address",property="address"),
		    @Result(column="province",property="province"),
		    @Result(column="city",property="city"),
		    @Result(column="district",property="district"),
		    @Result(column="jglb",property="jglb"),
		    @Result(column="picture",property="picture"),
			@Result(column="state",property="state")})
	public List<user> findAll();
	

	@Select("select username,name,phone,address,b.dict_item_name province,c.dict_item_name city,d.dict_item_name district,e.dict_item_name jglb,picture from user a "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '001') b ON a.province = b.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '002') c ON a.city = c.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '003') d ON a.district = d.dict_id "
			+ "LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '009') e ON a.jglb = e.dict_id  where authority='ROLE_TT'")
	@Results(id="TT_userResult",value={
			@Result(column="username",property="username"),
			@Result(column="name",property="name"),  
		    @Result(column="phone",property="phone"),
		    @Result(column="address",property="address"),
		    @Result(column="province",property="province"),
		    @Result(column="city",property="city"),
		    @Result(column="district",property="district"),
		    @Result(column="jglb",property="jglb"),
		    @Result(column="picture",property="picture")})
	public List<user> findTTAll();
	
	
	 @Select("SELECT username,name,phone,address,b.dict_item_name province,c.dict_item_name city,d.dict_item_name district,picture,e.dict_item_name state,f.dict_item_name jglb FROM USER a "
			  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '001') b ON a.province = b.dict_id "
			  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '002') c ON a.city = c.dict_id "
			  + "	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '003') d ON a.district = d.dict_id "
			  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '008') e ON a.state = e.dict_id "
			  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '009') f ON a.jglb = f.dict_id "
			  + "	WHERE (phone LIKE CONCAT(CONCAT('%', #{phone}, '%')))  "
			  + "AND (name LIKE CONCAT(CONCAT('%', #{name}, '%')))"
			  + "AND (province IS NULL OR province LIKE CONCAT(CONCAT('%', #{province}, '%')))"
			  + "AND (city IS NULL OR city LIKE CONCAT(CONCAT('%', #{city}, '%')))"
			 + "AND (district IS NULL OR district LIKE CONCAT(CONCAT('%', #{district}, '%')))"
			 + "AND (jglb IS NULL OR jglb LIKE CONCAT(CONCAT('%', #{jglb}, '%')))"
			 +"AND authority='ROLE_TT'")			
			@Results(id="part_tt_userResult",value={		  		  
			@Result(column="username",property="username"),
			@Result(column="name",property="name"),  
			@Result(column="phone",property="phone"),
			@Result(column="address",property="address"),
			@Result(column="province",property="province"),
			@Result(column="city",property="city"),
			@Result(column="district",property="district"),
			@Result(column="jglb",property="jglb"),
			@Result(column="picture",property="picture"),
			@Result(column="state",property="state")})
	public List<user> findTT(String name, String phone, String province, String city, String district,String jglb);
	
	
	  @Select("SELECT id,username,name,phone,address,b.dict_item_name province,c.dict_item_name city,d.dict_item_name district,picture,e.dict_item_name state,f.dict_item_name jglb FROM USER a "
	  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '001') b ON a.province = b.dict_id "
	  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '002') c ON a.city = c.dict_id "
	  + "	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '003') d ON a.district = d.dict_id "
	  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '008') e ON a.state = e.dict_id "
	  +"	LEFT JOIN (SELECT dict_id,dict_item_name FROM base_dict WHERE dict_type_code = '009') f ON a.jglb = f.dict_id "
	  + "	WHERE (phone LIKE CONCAT(CONCAT('%', #{phone}, '%')))  "
	  + "AND (name LIKE CONCAT(CONCAT('%', #{name}, '%')))"
	  + "AND (city IS NULL OR city LIKE CONCAT(CONCAT('%', #{city}, '%')))"
	 + "AND (district IS NULL OR district LIKE CONCAT(CONCAT('%', #{district}, '%')))"
	 + "AND (jglb IS NULL OR jglb LIKE CONCAT(CONCAT('%', #{jglb}, '%')))"
	 + "AND (province IS NULL OR province LIKE CONCAT(CONCAT('%', #{province}, '%')))")
	@Results(id="part_userResult",value={
	@Result(column="username",property="username"),
	@Result(column="name",property="name"),  
	@Result(column="phone",property="phone"),
	@Result(column="address",property="address"),
	@Result(column="province",property="province"),
	@Result(column="city",property="city"),
	@Result(column="district",property="district"),
	@Result(column="jglb",property="jglb"),
	@Result(column="picture",property="picture"),
	@Result(column="state",property="state")})
	public List<user> find(String name, String phone, String province, String city, String district,String jglb);
	
	@Update("update user set name=#{name},phone=#{phone},province=#{province},city=#{city},district=#{district},address=#{address},picture=#{picture},jglb=#{jglb} where username=#{username}")
	public int updateTT(String username, String name, String phone, String province, String city,
			String district, String address,String picture, String jglb);
	@Update("update user set state=#{state} where username=#{username}")
	public int updateuser(user user);
	@Delete("DELETE FROM USER WHERE id=#{id}")
	public int deleteuser(user user);
	@Delete("DELETE FROM user_role WHERE user_id=#{id}")
	public int delete_user_role(user user);
	 @Select("select state from user where username = #{username}") 
	public String findLogin_Role(String username);

	

	
	
}
