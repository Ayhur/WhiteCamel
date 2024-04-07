package com.example.escaping.buscador;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "localidades")
public class BusquedaDTO {
	
	@Id
	@Column(name = "idlocalidades")
    private Integer id_localidades;
	
	@Column(name = "nombre")
    private String ciudad;
		   
    
	public Integer getId_localidades() {
		return id_localidades;
	}
	public void setId_localidades(Integer id_localidades) {
		this.id_localidades = id_localidades;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public BusquedaDTO(Integer id_localidades, Long id_provincia, String ciudad) {
		super();
		this.id_localidades = id_localidades;
		this.ciudad = ciudad;
	}
	public BusquedaDTO() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, id_localidades);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusquedaDTO other = (BusquedaDTO) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(id_localidades, other.id_localidades);
	}
	public BusquedaDTO(Integer id_localidades, String ciudad) {
		super();
		this.id_localidades = id_localidades;
		this.ciudad = ciudad;
	}
	
    
    

   
    // Constructor, Getters y Setters
}

