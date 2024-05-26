package com.white.camel.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.white.camel.test.model.MenuData;
import com.white.camel.test.model.QuestionDTO;

public interface TestRepository extends JpaRepository<MenuData, Integer> {

	
	
//	@Query("SELECT * FROM MenuData")
//	List<MenuData> getMenuList();

}
