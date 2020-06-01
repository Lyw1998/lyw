package com.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component("AuthenticationFailureHandler")
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private String defaultFailureUrl;
	private boolean forwardToDestination = false;

    public static final String AUTHENTICATION_EXCEPTION = "SPRING_SECURITY_LAST_EXCEPTION";


	
	  public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException e) throws
	  IOException, ServletException,AuthenticationException {
		  defaultFailureUrl ="/gt_login?error=true";
		  System.out.println(e.getMessage());
			if (defaultFailureUrl == null) {
				logger.debug("No failure URL set, sending 401 Unauthorized error");
				response.sendError(HttpStatus.UNAUTHORIZED.value(),
					HttpStatus.UNAUTHORIZED.getReasonPhrase());
			}
			else {
				saveException(request, e);
				if (forwardToDestination) {
					  System.out.println("else-if");
					logger.debug("Forwarding to " + defaultFailureUrl);
					request.getRequestDispatcher(defaultFailureUrl)
							.forward(request, response);
				}
				else {
					  System.out.println("else-else");
					logger.debug("Redirecting to " + defaultFailureUrl);
					redirectStrategy.sendRedirect(request, response,defaultFailureUrl);
				}
			}
	  
	  }
	  
	
}
