package com.example.escaping.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.escaping.login.model.LoginData;

@Repository
public interface LoginRepository extends JpaRepository<LoginData, String> {
	
	public LoginData getLogginByUsernameAndPassword(String username, String password);

}
