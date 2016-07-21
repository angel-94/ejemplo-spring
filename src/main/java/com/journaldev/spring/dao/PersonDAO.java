package com.journaldev.spring.dao;

import java.util.List;
import com.journaldev.spring.model.Persona;

//interface que contiene las declarativas de los metodos de la calse perona dao
public interface PersonDAO {

	public void addPerson(Persona p);					//Añade los datos de una persona
	public void updatePerson(Persona p);			//Actualiza los datos de la persona
	public List<Persona> listPersons();				//Mustra la lista de las personas
	public Persona getPersonById(int id);			//Regresa los datos de la persona por su id
	public void removePerson(int id);					//Elimina a la persona de la BD.
}
