package com.white.camel.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.white.camel.login.model.LoginData;

@Repository
public interface LoginRepository extends JpaRepository<LoginData, Long> {
	
    @Query("SELECT l FROM LoginData l WHERE l.dni = :dni AND l.password = :password")
    LoginData getLoginByDniAndPassword(@Param("dni") String dni, @Param("password") String password);
}
