package com.example.escaping.scores.service.impl;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.escaping.scores.ScoreRow;
import com.example.escaping.scores.model.ScoresData;
import com.example.escaping.scores.repository.ScoresRepository;
import com.example.escaping.scores.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService {
	private ScoresRepository scoresRepository;

	public ScoresServiceImpl(ScoresRepository scoresRepository) {
		this.scoresRepository = scoresRepository;
	}

	@Override
	public List<ScoreRow> getScores(String dni) {
		return scoresRepository.getScoresByDni(dni, Sort.by("fecha").descending().and(Sort.by("hora")), Limit.of(5));
	}

}
