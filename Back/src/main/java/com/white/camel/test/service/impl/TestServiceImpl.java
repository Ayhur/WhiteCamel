package com.white.camel.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.white.camel.test.model.MenuData;
import com.white.camel.test.model.QuestionDTO;
import com.white.camel.test.repository.TestRepository;
import com.white.camel.test.repository.TestRepositoryCustom;
import com.white.camel.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	private TestRepository testRepository;

	private TestRepositoryCustom testRepositoryCustom;

	/** Constructor
	 * @param testRepository
	 * @param testRepositoryCustom
	 */
	public TestServiceImpl(TestRepository testRepository, TestRepositoryCustom testRepositoryCustom) {
		this.testRepository = testRepository;
		this.testRepositoryCustom = testRepositoryCustom;
	}

	/**
	 * Devuelve todos los nombres de los test existentes para cargar
	 * las opciones del menu.
	 * 
	 * @return
	 */
	@Override
	public List<MenuData> getMenuList() {
		return testRepository.findAll();
	}
	
	@Override
	public List<QuestionDTO> getTest() {
		return testRepositoryCustom.findTestDetailsByTestId();
	}

}
