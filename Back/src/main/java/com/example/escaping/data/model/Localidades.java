package com.example.escaping.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "localidades")
public class Localidades {

    @Id
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidades")
    private Integer id_localidades;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "id_provincia")
    private Integer id_provincia;
    
    public Localidades(Integer id, Integer id_localidades, String nombre, Integer id_provincia) {
		super();
		this.id = id;
		this.id_localidades = id_localidades;
		this.nombre = nombre;
		this.id_provincia = id_provincia;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_localidades() {
		return id_localidades;
	}

	public void setId_localidades(Integer id_localidades) {
		this.id_localidades = id_localidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(Integer id_provincia) {
		this.id_provincia = id_provincia;
	}

	
	

    // Getters and setters (you can generate them automatically)

    // toString, hashCode, and equals methods can be included here if needed
}
