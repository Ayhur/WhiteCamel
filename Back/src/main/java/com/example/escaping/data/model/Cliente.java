package com.example.escaping.data.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dni", length = 9)
    private String dni;

    @Column(name = "Nombre", length = 18)
    private String nombre;

    @Column(name = "Apellidos", length = 36)
    private String apellidos;

    @Column(name = "Direccion", length = 60)
    private String direccion;

    @Column(name = "Telefono", length = 11)
    private String telefono;

    @Column(name = "sexo", length = 1)
    private String sexo; // 'M' or 'F'

    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "usuario", length = 18)
    private String usuario;

    @Column(name = "password", length = 18)
    private String password;

    @Column(name = "provincias")
    private Integer provincias;

    @Column(name = "localidad")
    private Integer localidad;
    
    

	public Cliente(String dni, String nombre, String apellidos, String direccion, String telefono, String sexo,
			String email, Integer edad, String usuario, String password, Integer provincias, Integer localidad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sexo = sexo;
		this.email = email;
		this.edad = edad;
		this.usuario = usuario;
		this.password = password;
		this.provincias = provincias;
		this.localidad = localidad;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
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

	public Integer getProvincias() {
		return provincias;
	}

	public void setProvincias(Integer provincias) {
		this.provincias = provincias;
	}

	public Integer getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Integer localidad) {
		this.localidad = localidad;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

    // Getters and setters (you can generate them automatically)

    // toString, hashCode, and equals methods can be included here if needed
}

