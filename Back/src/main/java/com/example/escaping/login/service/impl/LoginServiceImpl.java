package com.example.escaping.login.service.impl;

import org.springframework.stereotype.Service;

import com.example.escaping.login.model.LoginData;
import com.example.escaping.login.repository.LoginRepository;
import com.example.escaping.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public LoginData getLogginData(LoginData data) {
		return loginRepository.getLogginByUsernameAndPassword(data.getUsername(), data.getPassword());
	}

}
