package com.journaldev.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.Persona;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

//Utilizan los metodos de la clase dao para hacer las operaciones sobre la BD.
	@Override
	@Transactional
	public void addPerson(Persona p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Persona p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Persona> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Persona getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

}
