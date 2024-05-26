package com.white.camel.usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente") // Asegúrate de que el nombre de la tabla sea correcto
public class UserRequest {

    @Id
    @NotBlank(message = "El DNI no puede estar vacío")
    @Pattern(regexp = "\\d{8}[A-HJ-NP-TV-Z]", message = "Formato de DNI no válido")
    private String dni;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(name = "Nombre") // Asegúrate de que el nombre de la columna coincida con la base de datos
    private String nombre;

    @NotBlank(message = "Los apellidos no pueden estar vacíos")
    @Column(name = "Apellidos")
    private String apellidos;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Column(name = "Direccion")
    private String direccion;

    // Asumiendo que el teléfono es único y no nulo en la base de datos
    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+?\\d{9,15}$", message = "Formato de teléfono no válido")
    @Column(name = "Telefono", unique = true)
    private String telefono;

    @NotBlank(message = "El sexo no puede estar vacío")
    @Column(name = "sexo")
    private String sexo;

    @Email(message = "Formato de email no válido")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "El usuario no puede estar vacío")
    @Column(name = "usuario", unique = true)
    private String usuario;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Column(name = "password")
    private String password;

    // Suponiendo que 'localidad' y 'provincias' son claves foráneas, deberías manejarlas como relaciones
    // Aquí simplemente se asume que son enteros que referencian a otra tabla
    @Column(name = "localidad")
    private Integer localidad;

    @Column(name = "provincias")
    private Integer provincias;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Integer localidad) {
		this.localidad = localidad;
	}

	public Integer getProvincias() {
		return provincias;
	}

	public void setProvincias(Integer provincias) {
		this.provincias = provincias;
	}

	public UserRequest(
			@NotBlank(message = "El DNI no puede estar vacío") @Pattern(regexp = "\\d{8}[A-HJ-NP-TV-Z]", message = "Formato de DNI no válido") String dni,
			@NotBlank(message = "El nombre no puede estar vacío") String nombre,
			@NotBlank(message = "Los apellidos no pueden estar vacíos") String apellidos,
			@NotBlank(message = "La dirección no puede estar vacía") String direccion,
			@NotBlank(message = "El teléfono no puede estar vacío") @Pattern(regexp = "^\\+?\\d{9,15}$", message = "Formato de teléfono no válido") String telefono,
			@NotBlank(message = "El sexo no puede estar vacío") String sexo,
			@Email(message = "Formato de email no válido") String email,
			@NotBlank(message = "El usuario no puede estar vacío") String usuario,
			@NotBlank(message = "La contraseña no puede estar vacía") @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") String password,
			Integer localidad, Integer provincias) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.localidad = localidad;
		this.provincias = provincias;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

    // Omitiré el resto del código que incluye getters, setters y constructores para brevedad
}
