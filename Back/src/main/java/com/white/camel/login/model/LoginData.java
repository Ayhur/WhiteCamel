package com.white.camel.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wh_user")
public class LoginData {
	
	@Id
	@Column(name = "wh_id")
	private Long id;
	
	@Column(name = "wh_dni")
	private String dni;
	
	@Column(name = "wh_password")
	private String password;
	
	@Column(name = "wh_nombre")
	private String nombre;
	
	@Column(name = "wh_apellido1")
	private String apellido1;
	
	@Column(name = "wh_apellido2")
	private String apellido2;
	
}
