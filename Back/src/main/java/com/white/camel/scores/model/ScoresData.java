package com.white.camel.scores.model;

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
	private Double puntuacion;

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
}
