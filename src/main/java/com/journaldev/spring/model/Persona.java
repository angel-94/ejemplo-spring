package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity											//Entidad???
@Table(name="PERSONAS")			//Nombre de la tabla de la BD.
public class Persona {
	@Id
	@Column(name="PersonaID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//Campos de la tabla de la BD.
	private int 		personaID;
	private String 	nombre;
	private String 	pais;
	private String 	telefono;
	private String 	direccion;
	private String 	correo;

	//Metodos getter y setter de la clase
	public int getPersonaID() {
		return personaID;
	}

	public void setPersonaID(int personaID) {
		this.personaID = personaID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString(){
		return "personaID="+personaID+", nombre="+nombre+", pais="+pais +", telefono="+telefono+ ", direccion="+direccion+ ", correo="+correo;
	}
}
