package com.example.escaping.buscador;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="alojamientodto")
public class AlojamientoDTO {
	private String nombre;
	@Id
	private Integer id;
	private String imagenUrl; // URL de la imagen del "hotel"

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	// Constructor, Getters y Setters
}
