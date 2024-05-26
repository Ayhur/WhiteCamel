package com.white.camel.test.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.white.camel.test.model.CorrectionDTO;
import com.white.camel.test.model.QuestionDTO;
import com.white.camel.test.model.ResponseDTO;
import com.white.camel.test.repository.TestRepositoryCustom;

public class TestRepositoryImpl implements TestRepositoryCustom {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public List<QuestionDTO> findTestDetailsByTestId(Integer idTest) {
		String sql = "SELECT t.wh_test_id, t.wh_test_titulo, p.wh_test_pre_id, p.wh_test_pre_descripcion, r.wh_test_res_id, r.wh_test_res_descripcion, c.wh_test_correcciones_res AS correct_res_id "
				+ "FROM wh_test t " + "JOIN wh_test_preguntas p ON t.wh_test_id = p.wh_test_pre_test "
				+ "JOIN wh_test_respuestas r ON p.wh_test_pre_id = r.wh_test_res_pre "
				+ "LEFT JOIN wh_test_correcciones c ON p.wh_test_pre_id = c.wh_test_correcciones_pre AND r.wh_test_res_id = c.wh_test_correcciones_res "
				+ "WHERE t.wh_test_id = ?";

		return jdbcTemplate.query(sql, new Object[] { idTest }, rs -> {
			Map<Long, QuestionDTO> questionMap = new HashMap<>();

			while (rs.next()) {
				Long questionId = rs.getLong("wh_test_pre_id");
				QuestionDTO question = questionMap.get(questionId);

				if (question == null) {
					question = new QuestionDTO();
					question.setQuestionId(questionId);
					question.setQuestionText(rs.getString("wh_test_pre_descripcion"));
					question.setResponses(new ArrayList<>());
					questionMap.put(questionId, question);
				}

				ResponseDTO response = new ResponseDTO();
				response.setResponseId(rs.getLong("wh_test_res_id"));
				response.setResponseText(rs.getString("wh_test_res_descripcion"));
				question.getResponses().add(response);

				Long correctResponseId = rs.getLong("correct_res_id");
				if (correctResponseId != 0) {
					CorrectionDTO correction = new CorrectionDTO();
					correction.setQuestionId(questionId);
					correction.setCorrectResponseId(correctResponseId);
					question.setCorrection(correction);
				}
			}

			return new ArrayList<>(questionMap.values());
		});
	}

}
