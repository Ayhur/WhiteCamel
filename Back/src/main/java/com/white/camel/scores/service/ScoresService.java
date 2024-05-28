package com.white.camel.scores.service;

import java.util.List;

import com.white.camel.scores.ScoreRow;

public interface ScoresService {
	public List<ScoreRow> getScores(String dni);
}
