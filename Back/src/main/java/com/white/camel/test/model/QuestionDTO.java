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

}
