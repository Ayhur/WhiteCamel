package com.white.camel.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.white.camel.login.model.LoginData;
import com.white.camel.login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("")
	public ResponseEntity<LoginData> login(@RequestBody LoginData loginData) {
		LoginData response = loginService.getLogginData(loginData);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
	}
	
}
