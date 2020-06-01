package com.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import com.security.AuthenticationFailureHandler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import com.controller.ValidateCodeController;
import com.pojo.ImageCode;
import com.security.ValidateCodeException;

/**
 * 定义一个验证码的拦截器
 * @author hdd
 */
public class ValidateCodeFilter extends OncePerRequestFilter {
    
    private AuthenticationFailureHandler AuthenticationFailureHandler;
 
 
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
 
    @ExceptionHandler(value=ValidateCodeException.class)
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException,AuthenticationException {
    	System.out.println("doFilterInternal");
        if (StringUtils.equals("/authentication/form", request.getRequestURI()) &&
                StringUtils.endsWithIgnoreCase(request.getMethod(), "post")) {
        	System.out.println("if");
        	try {
        		System.out.println("try");
                validate(new ServletWebRequest(request));
            } catch (ValidateCodeException e) {
            	
                AuthenticationFailureHandler.onAuthenticationFailure(request,response,e);
           
                return ;
            }
        }
        System.out.println("end");
        filterChain.doFilter(request,response);
    }
 
    //具体的验证流程
    @ExceptionHandler
	private void validate(ServletWebRequest request) throws ServletRequestBindingException,AuthenticationException {
    	ImageCode codeInSession = (ImageCode) sessionStrategy.getAttribute(request, ValidateCodeController.SESSION_KEY);
    	String codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }
		/*
		 * if (codeInSession == null) { throw new ValidateCodeException("验证码不存在"); }
		 */
        if (codeInSession.isExpried()) {
            sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
    }
 
    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return AuthenticationFailureHandler;
    }
 
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler AuthenticationFailureHandler) {
        this.AuthenticationFailureHandler = AuthenticationFailureHandler;
    }





}
