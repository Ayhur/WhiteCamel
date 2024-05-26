package com.white.camel.test.service;

import java.util.List;

import com.white.camel.test.model.MenuData;
import com.white.camel.test.model.QuestionDTO;

public interface TestService {
	
	/**
	 * Devuelve todos los nombres de los test existentes para cargar
	 * las opciones del menu.
	 * @return
	 */
	List<MenuData> getMenuList();
	
	/**
	 * 
	 * @param idTest
	 * @return
	 */
	List<QuestionDTO> getTest(Integer idTest);

}
