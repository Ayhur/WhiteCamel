package com.white.camel.test.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.white.camel.test.model.MenuData;
import com.white.camel.test.model.QuestionDTO;
import com.white.camel.test.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	private TestService testService;

	public TestController(TestService testService) {
		this.testService = testService;
	}

	@PostMapping("/menu")
	public ResponseEntity<List<MenuData>> login() {
		List<MenuData> response = testService.getMenuList();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/test")
	public ResponseEntity<List<QuestionDTO>> getTest(@RequestBody Integer idTest) {
		List<QuestionDTO> response = testService.getTest();
		return ResponseEntity.ok(response);
	}

}
