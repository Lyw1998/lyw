package com.repository;


import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import com.pojo.role;
import com.pojo.pet;
import com.pojo.user;

public interface UserMapper {
	
	// 根据loginName查询用户信息，同时关联查询出用户的权限
	@Select("select * from user where username = #{username}")
	 @Results({  
	        @Result(id=true,column="id",property="id"),  
	        @Result(column="username",property="username"),  
	        @Result(column="password",property="password"),
	        @Result(column="name",property="name"),
	        @Result(column="phone",property="phone"),
	        @Result(column="province",property="province"),
	        @Result(column="city",property="city"),
	        @Result(column="district",property="district"),
	        @Result(column="picture",property="picture"),
	        @Result(column="state",property="state"),  
	        @Result(column="id",property="roles",
	        many=@Many(select="findRoleByUser",
	        fetchType=FetchType.EAGER))  
	     })  
		user findUserByUsername(String username);	
	  
		
	  // 根据用户id关联查询用户的所有权限
		  
		  @Select(" SELECT id,authority FROM role r,user_role ur " +
		  " WHERE r.id = ur.role_id AND user_id = #{id}")
		  List<role> findRoleByUser(int id);
		  
		 
		
}
