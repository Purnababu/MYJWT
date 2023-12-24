package com.example.JWTPRACTICE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWTPRACTICE.configue.CustomeUserSecrviceImple;
import com.example.JWTPRACTICE.configue.JwtRequest;
import com.example.JWTPRACTICE.configue.JwtResponse;
import com.example.JWTPRACTICE.configue.JwtUtil;

@RestController
public class JwtController {

	@Autowired
	private CustomeUserSecrviceImple custom;

	@Autowired
	private JwtUtil util;
	
	 @Autowired
	private AuthenticationManager authenticationManager;
	
	 
	 @PostMapping("/generate-token")
	 public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest){
		 authnticate(jwtRequest.getUsername() , jwtRequest.getPassword());
		 
		 UserDetails userDetails = this.custom.loadUserByUsername(jwtRequest.getUsername());
		 String genetaeToken = this.util.generateToken(userDetails);
		 
		 return ResponseEntity.ok(new JwtResponse(genetaeToken));
		 
	 }
	 
	 private void authnticate(String username,String password) {
		 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		 
	 }
}
