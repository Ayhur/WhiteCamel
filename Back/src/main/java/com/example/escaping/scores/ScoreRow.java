package com.example.escaping.scores;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ScoreRow {
	LocalDate getFecha();

	LocalTime getHora();

	Float getPuntuacion();
}
