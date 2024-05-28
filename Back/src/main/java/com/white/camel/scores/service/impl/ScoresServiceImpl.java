package com.white.camel.scores.service.impl;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.white.camel.scores.ScoreRow;
import com.white.camel.scores.model.ScoresData;
import com.white.camel.scores.repository.ScoresRepository;
import com.white.camel.scores.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService {
	private ScoresRepository scoresRepository;

	public ScoresServiceImpl(ScoresRepository scoresRepository) {
		this.scoresRepository = scoresRepository;
	}

	@Override
	public List<ScoreRow> getScores(String dni) {
		return scoresRepository.getScoresByDni(
				dni,
				Sort.by("fecha").descending().and(Sort.by("hora").descending()),
				Limit.of(5));
	}

	@Override
	public void saveScore(ScoresData score) {
		this.scoresRepository.save(score);
	}

}
