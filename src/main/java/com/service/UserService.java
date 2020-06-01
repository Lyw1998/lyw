package com.service;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.pojo.ImageCode;
import com.pojo.role;
import com.controller.ValidateCodeController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.user;
import com.pojo.user_role;
import com.repository.UserMapper;
import com.repository.UserRepository;
import com.security.ValidateCodeException;
import com.utils.Page;

/**
 * 需要实现UserDetailsService接口 因为在Spring Security中我们配置相关参数需要UserDetailsService类型的数据
 */
@Service
public class UserService implements UserDetailsService {

	// 注入持久层接口UserMapper
	@Autowired
	UserMapper userMapper;
	@Resource
	private UserRepository userRepository;
	

	
	// 实现接口中的loadUserByUsername方法，通过该方法查询到对应的用户
	public UserDetails loadUserByUsername(String username) throws AuthenticationException {
	  //调用持久层接口findByLoginName方法查找用户，此处的传进来的参数实际是loginName

		
		 user u=userMapper.findUserByUsername(username);
		 if (u == null) {
		  throw new UsernameNotFoundException("用户不存在");
		  }
		// 创建List集合，用来保存用户权限，GrantedAuthority对象代表赋予给当前用户的权限 
		
		  List<GrantedAuthority> authorities = new ArrayList<>(); 
		  List<role> roles =u.getRoles(); for(role role : roles) { // 将关联对象Role的authority属性保存为用户的认证权限
		  authorities.add(new SimpleGrantedAuthority(role.getAuthority())); }
		 
	  //此处返回的是org.springframework.security.core.userdetails.User类，该类是SpringSecurity内部的实现
		
		  if ((u.getState()).matches("29")) { 
			 throw new LockedException("您的帐号没有登录权限,请联系管理员 13556703216激活!");
		} 
		    else {
		return new User(u.getUsername(),u.getPassword(), authorities); 
		 }
} 
	

	
	public int gt_register(user user) {
		return userRepository.gt_register(user);
	}

	public int tt_register(user user) {
		return userRepository.tt_register(user);
	}

	public int gt_register_role(user_role user_role) {
		return userRepository.gt_register_role(user_role);		
	}

	public int tt_register_role(user_role user_role) {
		return userRepository.tt_register_role(user_role);		
	}
	
	/*
	 * public List<user> findAll(){ return userRepository.findAll(); }
	 */
	
	public PageInfo<user> findAll(Integer page, Integer pageSize ){
		   PageHelper.startPage(page,pageSize);//分页起始码以及每页页数
		    List<user> users=userRepository.findAll(); 
		    PageInfo pageInfo=new PageInfo(users);
		    System.out.println(pageInfo);
		return pageInfo;
	}

	public List<user> findTTAll() {
		return userRepository.findTTAll();
	}
	
	public List<user> findTT(String name, String phone, String province, String city, String district,String jglb) {
		return userRepository.findTT(name,phone,province,city,district,jglb);
	}
	
	public List<user> find(String name, String phone, String province, String city, String district,String jglb) {
		return userRepository.find(name,phone,province,city,district, jglb);
	}

	public int updateTT(String username, String name, String phone, String province, String city,
			String district,String address,String picture, String jglb) {
		return userRepository.updateTT(username, name, phone,province,city,
				district,address,picture,jglb);		
	}

	public int updateuser(user user) {
		return userRepository.updateuser(user);	
	}

	public int deleteuser(user user) {
		return userRepository.deleteuser(user);		
	}

	public int delete_user_role(user user) {
		return userRepository.delete_user_role(user);	
		
	}

	public String findLogin_Role(String username) {
		return userRepository.findLogin_Role(username);
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasename("classpath:resource"); 
		return reloadableResourceBundleMessageSource;
		}

}
