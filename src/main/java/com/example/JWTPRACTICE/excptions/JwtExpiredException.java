package com.example.JWTPRACTICE.excptions;

@SuppressWarnings("serial")
public class JwtExpiredException extends RuntimeException {

	public JwtExpiredException(String msg) {
		super(msg);
	}

}
