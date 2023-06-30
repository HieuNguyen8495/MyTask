package com.example.MyTask.security.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTask.security.dto.LoginDto;
import com.example.MyTask.security.jwt.JwtUtils;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(Jwts.class);
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	
	public AuthController(AuthenticationManager authManager, JwtUtils jwtUtils) {
		authenticationManager = authManager;
		this.jwtUtils = jwtUtils;
	}
	

	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginDto dto) {
		
		Authentication auth = null;
		
		try {
			auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
				
			SecurityContextHolder.getContext().setAuthentication(auth);
			String token = jwtUtils.generateJwtToken(auth);
			
			return new ResponseEntity<>(token,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.debug("{} has been logged in with wrong password: {}",dto.getUsername(), e.getMessage() );
		}
		
		return new ResponseEntity<>("Username or Password is invalid",HttpStatus.BAD_REQUEST);
	}
}
