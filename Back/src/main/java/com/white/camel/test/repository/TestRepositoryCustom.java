package com.white.camel.test.repository;

import java.util.List;

import com.white.camel.test.model.QuestionDTO;

public interface TestRepositoryCustom {

	List<QuestionDTO> findTestDetailsByTestId();

}
