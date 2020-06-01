package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pojo.pet;
import com.pojo.user;

import com.repository.UserMapper;
import com.service.PetService;
import com.service.UserService;

@Controller
public class AppController {

	
	@Resource
	UserService userService;
	@Resource
	UserMapper userMapper;
	@RequestMapping(value = "/")
	public String login() {
		return "forward:/gt_login";
	}
	
	
	  @RequestMapping(value = "/gt_login")
	  public String gt_login() { 
		  return  "gt_login"; 
		  }
	 

	@RequestMapping("/gt_register")
	public String gt_register() {
		return "gt_register";
	}

	@RequestMapping("/tt_register")
	public String tt_register() {
		return "tt_register";
	}

	@RequestMapping(value = "/UserManager")
	public String UserManager() {
		return "UserManager";
	}

	@RequestMapping(value = "/RescueManager")
	public String RescueManager(Model model) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		return "RescueManager";
	}

	@RequestMapping(value = "/AdoptSelect")
	public String AdoptSelect() {
		return "AdoptSelect";
	}

	@RequestMapping(value = "/RescueSelect")
	public String RescueSelect() {
		return "RescueSelect";
	}

	@RequestMapping(value = "/AdoptManager")
	public String AdoptManager() {
		return "AdoptManager";
	}

	@RequestMapping(value = "/addPet")
	public String addPet() {
		return "/pet/addPet";
	}

	/*
	 * @RequestMapping(value = "/addPet") public String addPet() { return
	 * "/pet/addPet"; }
	 */

	
	  @RequestMapping(value = "/updatePet") 
	  public String updatePet() { 
		  return "/pet/updatePet"; 
		  }
	 

	@RequestMapping(value = "/deletePet")
	public String deletePet() {
		return "/pet/deletePet";
	}
	


	@RequestMapping(value = "/accessDenied")
	public String accessDeniedPage(Model model) {
		model.addAttribute("user", getUsername());
		model.addAttribute("role", getAuthority());
		return "accessDenied";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		// Authentication是一个接口，表示用户认证信息
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// 如果用户认知信息不为空，注销
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		// 重定向到login页面
		return "redirect:/gt_login";
	}

	/**
	 * 获得当前用户名称
	 */
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
