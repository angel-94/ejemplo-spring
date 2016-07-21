package com.journaldev.spring.service;

import java.util.List;
import com.journaldev.spring.model.Persona;

public interface PersonService {
	public void addPerson(Persona p);					//inserta los datos de una persona
	public void updatePerson(Persona p);			//Actualiza los datos de la persona
	public List<Persona> listPersons();				//Muestra los datos de todas las personas
	public Persona getPersonById(int id);			//Obtiene los datos de una persona por su id.
	public void removePerson(int id);					//Elimina a una persona de la BD.
}
