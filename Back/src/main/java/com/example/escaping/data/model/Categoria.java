package com.example.escaping.data.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "nombre", length = 34)
    private String nombre;

    @Column(name = "id_categoria_ref")
    private Integer id_categoria_ref;
    
    

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Integer id_categoria, String nombre, Integer id_categoria_ref) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.id_categoria_ref = id_categoria_ref;
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

	public Integer getId_categoria_ref() {
		return id_categoria_ref;
	}

	public void setId_categoria_ref(Integer id_categoria_ref) {
		this.id_categoria_ref = id_categoria_ref;
	}

    // Constructor por defecto
   
   
    // toString, hashCode y equals métodos pueden ser incluidos aquí si son necesarios
}

