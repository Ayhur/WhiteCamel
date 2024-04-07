package com.example.escaping.data.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categorias implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "nombre", length = 36)
    private String nombre;
    
    

	public Categorias() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorias(Integer id_categoria, String nombre) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
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
