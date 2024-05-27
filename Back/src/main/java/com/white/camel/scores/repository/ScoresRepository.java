package com.white.camel.scores.repository;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.white.camel.scores.model.ScoresData;
import com.white.camel.scores.ScoreRow;

@Repository
public interface ScoresRepository extends JpaRepository<ScoresData, Long> {
	@Query("SELECT l.fecha AS fecha, l.hora AS hora, l.puntuacion as puntuacion FROM ScoresData l WHERE l.dni = :dni")
	List<ScoreRow> getScoresByDni(@Param("dni") String dni, Sort sort, Limit limit);
}
