package com.white.camel.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subcategorias")
public class Subcategorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcat")
    private Integer id_subcat;

    @Column(name = "nombre", length = 36)
    private String nombre;
    
    @Column(name = "id_categoria", length = 36)
    private Integer id_categoria;
    
    public Subcategorias(Integer id_subcat, String nombre, Integer id_categoria) {
		super();
		this.id_subcat = id_subcat;
		this.nombre = nombre;
		this.id_categoria = id_categoria;
	}


	public Integer getId_subcat() {
		return id_subcat;
	}

	public void setId_subcat(Integer id_subcat) {
		this.id_subcat = id_subcat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	
	

	
    // Getters and setters (you can generate them automatically)

    // toString, hashCode, and equals methods can be included here if needed
}
