package com.example.escaping.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class LoginData {
	
	@Id
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "usuario")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "edad")
	private String edad;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public LoginData(String username, String password, String dni, String nombre, String apellidos, String direccion,
			String telefono, String sexo, String email, String edad) {
		super();
		this.username = username;
		this.password = password;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.email = email;
		this.edad = edad;
	}

	public LoginData() {
	}

	@Override
	public String toString() {
		return "LoginData [username=" + username + ", password=" + password + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", sexo=" + sexo
				+ ", email=" + email + ", edad=" + edad + "]";
	}

}
