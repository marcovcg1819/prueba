package com.empresa.entities;

public class PersonaGenerica {
	private String nombre;
	private String apellidos;
	private String numeroDocumento;
	private Integer tiempoconocerse;
	private Integer edad;
	private String parentesco;
	private Integer porcentaje;
	
	
	
	public PersonaGenerica() {
		super();
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
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Integer getTiempoconocerse() {
		return tiempoconocerse;
	}
	public void setTiempoconocerse(Integer tiempoconocerse) {
		this.tiempoconocerse = tiempoconocerse;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public Integer getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}

	
}
