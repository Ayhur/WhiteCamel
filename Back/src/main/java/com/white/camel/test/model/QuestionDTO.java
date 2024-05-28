package com.white.camel.test.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

	private Long questionId;

	private String questionText;

	private List<ResponseDTO> responses;

	private CorrectionDTO correction;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<ResponseDTO> getResponses() {
		return responses;
	}

	public void setResponses(List<ResponseDTO> responses) {
		this.responses = responses;
	}

	public CorrectionDTO getCorrection() {
		return correction;
	}

	public void setCorrection(CorrectionDTO correction) {
		this.correction = correction;
	}

}
