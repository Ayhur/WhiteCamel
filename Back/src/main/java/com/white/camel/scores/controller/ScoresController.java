package com.white.camel.scores.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.white.camel.scores.ScoreRow;
import com.white.camel.scores.model.ScoresData;
import com.white.camel.scores.service.ScoresService;

@RestController
@RequestMapping("/scores")
public class ScoresController {
	private ScoresService scoresService;

	public ScoresController(ScoresService scoresService) {
		this.scoresService = scoresService;
	}

	@GetMapping("/{dni}")
	public ResponseEntity<List<ScoreRow>> scores(@PathVariable String dni) {
		System.out.println("getting scores");
		List<ScoreRow> response = scoresService.getScores(dni);
		if (response != null) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@PostMapping("")
	public void uploadScore(@RequestBody Map<String, Object> payload) {
		ScoresData score = new ScoresData();
		score.setDni((String) payload.get("dni"));
		score.setFecha(LocalDate.now());
		score.setHora(LocalTime.now());
		Object puntuacion = payload.get("puntuacion");
		if (puntuacion instanceof Integer) {
			score.setPuntuacion(((Integer) puntuacion).doubleValue());
		} else {
			score.setPuntuacion((Double) puntuacion);
		}

		this.scoresService.saveScore(score);
	}
}
