package com.white.camel.test.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.white.camel.test.model.MenuData;

public interface TestRepository extends JpaRepository<MenuData, Integer> {
	
}
