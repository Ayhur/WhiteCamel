package com.example.escaping.scores.service;

import java.util.List;

import com.example.escaping.scores.ScoreRow;

public interface ScoresService {
	public List<ScoreRow> getScores(String dni);
}
