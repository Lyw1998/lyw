package com.controller;

import java.io.File;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.pet;
import com.pojo.user;
import com.pojo.user_role;
import com.service.BasedictService;
import com.service.UserService;
import com.github.pagehelper.PageInfo;
import com.pojo.basedict;
import com.utils.Page;


@Controller
public class UserController {	
	
	@Resource
	UserService userService;

	
	@RequestMapping(value = "/gt_user")
	public String gt_user(Model model/*,user us*/) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		return "/gt_user";
	}
	
	@RequestMapping(value = "/tt_user")
	public String tt_user(Model model) {
	
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		return "/tt_user";
	}
	
	
	@RequestMapping(value = "/sp_user")
	public String sp_user(Model model) {
		
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		return "/sp_user";
	}
	
	@RequestMapping("/g_register")
	public String g_register(user user, user_role user_role) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.gt_register(user);
		userService.gt_register_role(user_role);
		return "gt_login";
	}
	
	@RequestMapping("/t_register")
	public String t_register(user user, user_role user_role) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.tt_register(user);
		userService.tt_register_role(user_role);
		
		System.out.println(user_role);	
		return "gt_login";
	}
	
	@RequestMapping(value = "/findAll")
	  @ResponseBody
	  public PageInfo<user> findAll(@RequestParam(value="page",defaultValue="1")Integer page,
			  @RequestParam(value="pageSize",defaultValue="5")Integer pageSize){
	    PageInfo<user> pageInfo=userService.findAll(page,pageSize);
	 
	    System.out.println("当前页："+ pageInfo.getPageNum()+",共"+pageInfo.getPages()+"页");
	    return pageInfo;
	    
	  }
	
	

	@RequestMapping("/findTTAll")
	@ResponseBody
	public List<user> findTTAll(){
		return userService.findTTAll();
	}
	
	@RequestMapping("/findTT")
	@ResponseBody
	public List<user> findTT(String name,String phone,String province,String city,String district,String jglb){
		return userService.findTT(name,phone,province,city,district,jglb);
	}
	
//	@PreAuthorize("hasRole('DBA')")
	@RequestMapping("/find")
	@ResponseBody
	public List<user> find(String name,String phone,String province,String city,String district,String jglb){
		System.out.println();
		System.out.println("na:"+name);
		System.out.println("ph:"+phone);
		System.out.println("pro:"+province);
		System.out.println("ci："+city);
		System.out.println("dis："+district);
		return userService.find(name,phone,province,city,district,jglb);
	}
	

	
	@RequestMapping("/updateuser")
	public String updateuser(user user) {
		userService.updateuser(user);
		return "updateuser";
	}
	
	@RequestMapping("/updateTT")
	public String updateTT(String username,String name,String phone,
			String province,String city,String district,String address,String picture,String jglb) {
		userService.updateTT(username,name,phone,province,city,district,address,picture,jglb);
		return "tt_user";
	}
	
	@RequestMapping("/deleteuser")
	public String deleteuser(user user) {
		userService.deleteuser(user);
		userService.delete_user_role(user);
		return "deleteuser";
	}
	
	/*
	 * @RequestMapping("/download") public ResponseEntity<byte[]>
	 * download(HttpServletRequest request,
	 * 
	 * @RequestParam("filename") String filename,@RequestHeader("User-Agent") String
	 * userAgent, Model model) throws Exception{ String
	 * path=request.getServletContext().getRealPath("/img/"); File file=new
	 * File(path+File.separator+filename); BodyBuilder builder=ResponseEntity.ok();
	 * builder.contentLength(file.length());
	 * filename=URLEncoder.encode(filename,"UTF-8"); if
	 * (userAgent.indexOf("MSIE")>0) {
	 * builder.header("Content-Disposition","attachment;filename="+filename); }else
	 * {
	 * builder.header("Content-Disposition","attachment;filename*='UTF-8'"+filename)
	 * ; } return builder.body(FileUtils.readFileToByteArray(file)); }
	 */
	
	@RequestMapping(value = "/Knowledge")
	public String Knowledge() {	
		return "/Knowledge";
	}
	@RequestMapping(value = "/notes")
	public String notes() {	
		return "/notes";
	}
	
	
	private String getUsername() {
		// 从SecurityContex中获得Authentication对象代表当前用户的信息
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("username = " + username);
		return username;
	}

	/**
	 * 获得当前用户权限
	 */
	private String getAuthority() {
		// 获得Authentication对象，表示用户认证信息。
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		List<String> roles = new ArrayList<String>();
		// 将角色名称添加到List集合
		for (GrantedAuthority a : authentication.getAuthorities()) {
			roles.add(a.getAuthority());
		}
		System.out.println("role = " + roles);
		return roles.toString();
	}


}
