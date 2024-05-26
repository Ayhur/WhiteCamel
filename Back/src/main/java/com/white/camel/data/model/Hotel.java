package com.white.camel.data.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hotel", nullable = false)
	private Integer id_hotel;

	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	@Column(name = "descripcion", nullable = false, length = 255)
	private String direccion;

	@Column(name = "telefono", length = 20)
	private String telefono;
	
	@Lob
	@Column(name = "imagenes", length = 20)
	private String imagen;
//	@Lob
//	@Column(name = "imagenes", length = 20)
//	private byte[] imagen;


	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_localidades")
	//@Column(name = "id_localidades", length = 20)
	private Localidades id_localidades;*/
	
//	@Column(name = "id_localidades")    
	@Column(name = "localidad")
	private Integer localidadId;
	// Este es el nombre de la propiedad que debes usar en tu consulta

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	private Categoria id_categoria;

	

	


	public Hotel(Integer id_hotel, String nombre, String direccion, String telefono, String imagen, Integer localidadId,
			Categoria id_categoria) {
		super();
		this.id_hotel = id_hotel;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.imagen = imagen;
		this.localidadId = localidadId;
		this.id_categoria = id_categoria;
	}






	public Integer getId_hotel() {
		return id_hotel;
	}






	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getDireccion() {
		return direccion;
	}






	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}






	public String getTelefono() {
		return telefono;
	}






	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}






	public String getImagen() {
		return imagen;
	}






	public void setImagen(String imagen) {
		this.imagen = imagen;
	}






	public Integer getLocalidadId() {
		return localidadId;
	}






	public void setLocalidadId(Integer localidadId) {
		this.localidadId = localidadId;
	}






	public Categoria getId_categoria() {
		return id_categoria;
	}






	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	




	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	

	// Getters y setters

	// toString, hashCode, equals methods can be added here if needed
}
