package com.white.camel.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincias")
public class Provincias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorias")
    private Integer id_categorias;

    @Column(name = "nombre", length = 50)
    private String nombre;
    
    

	public Provincias(Integer id_categorias, String nombre) {
		super();
		this.id_categorias = id_categorias;
		this.nombre = nombre;
	}

	public Integer getId_categorias() {
		return id_categorias;
	}

	public void setId_categorias(Integer id_categorias) {
		this.id_categorias = id_categorias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	

  

    // Getters and setters (you can generate them automatically)

    // toString, hashCode, and equals methods can be included here if needed
}

