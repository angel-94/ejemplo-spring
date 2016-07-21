package com.journaldev.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.journaldev.spring.model.Persona;

@Repository
public class PersonDAOImpl implements PersonDAO {

		private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf){
				this.sessionFactory = sf;
		}

		@Override
		public void addPerson(Persona p) {
				Session session = this.sessionFactory.getCurrentSession();
				session.persist(p);
				logger.info("Los datos de la persona se guardaron correctamente, Detalles de la persona="+p);
		}

		@Override
		public void updatePerson(Persona p) {
				Session session = this.sessionFactory.getCurrentSession();
				session.update(p);
				logger.info("Datos de la persona actiualizados correctamente, Detalles de la persona="+p);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Persona> listPersons() {
				Session session = this.sessionFactory.getCurrentSession();
				List<Persona> listaPersonas = session.createQuery("from Persona").list();
				for(Persona p : listaPersonas){
						logger.info("Lista de las personas::"+p);
				}
				return listaPersonas;
		}

		@Override
		public Persona getPersonById(int id) {
				Session session = this.sessionFactory.getCurrentSession();
				Persona p = (Persona) session.load(Persona.class, new Integer(id));
				logger.info("Datos de la persona fue cargada satisfactoriamente (getPersonById), Detalles de la persona="+p);
				return p;
		}

		@Override
		public void removePerson(int id) {
				Session session = this.sessionFactory.getCurrentSession();
				Persona p = (Persona) session.load(Persona.class, new Integer(id));
				if(null != p){
						session.delete(p);
				}
				logger.info("Los datos de la persona se eliminaron correctamente, Detalles de la persona="+p);
		}

}
