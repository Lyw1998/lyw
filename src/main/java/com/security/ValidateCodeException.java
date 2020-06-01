package com.security;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException{

	public ValidateCodeException(String msg) throws AuthenticationException{
		super(msg);
	}

}
