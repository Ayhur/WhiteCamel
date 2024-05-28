package com.white.camel.scores.service;

import java.util.List;

import com.white.camel.scores.ScoreRow;
import com.white.camel.scores.model.ScoresData;

public interface ScoresService {
	public List<ScoreRow> getScores(String dni);
	public void saveScore(ScoresData score);
}
