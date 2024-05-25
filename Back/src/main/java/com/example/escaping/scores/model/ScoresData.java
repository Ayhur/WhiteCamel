package com.example.escaping.scores.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wh_scores")
public class ScoresData {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "dni")
	private String dni;

	@Column(name = "fecha", columnDefinition = "DATE")
	private LocalDate fecha;

	@Column(name = "hora", columnDefinition = "TIME")
	private LocalTime hora;

	@Column(name = "puntuacion")
	private Float puntuacion;
}
