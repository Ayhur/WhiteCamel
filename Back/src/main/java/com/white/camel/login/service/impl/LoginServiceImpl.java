package com.white.camel.login.service.impl;

import org.springframework.stereotype.Service;

import com.white.camel.login.model.LoginData;
import com.white.camel.login.repository.LoginRepository;
import com.white.camel.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public LoginData getLogginData(LoginData data) {
		return loginRepository.getLoginByDniAndPassword(data.getDni(), data.getPassword());
	}

}
