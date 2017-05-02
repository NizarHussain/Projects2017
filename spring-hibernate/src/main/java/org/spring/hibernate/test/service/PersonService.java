package org.spring.hibernate.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.hibernate.test.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for processing Persons
 * 
 */
@Service("personService")
@Transactional
public class PersonService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all persons
	 * 
	 * @return a list of persons
	 */
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Person");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Adds a new person
	 * 
	 * @param firstName the first name of the person
	 * @param lastName the last name of the person
	 * @param money the money of the person
	 */
	public void add(Person person) {
		logger.debug("Adding new person");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a new person
		Person dbPerson = new Person();
		dbPerson.setFirstName(person.getFirstName());
		dbPerson.setLastName(person.getLastName());
		dbPerson.setMiddleName(person.getMiddleName());
		dbPerson.setGender(person.getGender());
		dbPerson.setAge(person.getAge());
		dbPerson.setPhone(person.getPhone());
		dbPerson.setZip(person.getZip());
		
		// Save
		session.save(person);
	}
	
	/**
	 * Deletes an existing person
	 * @param id the id of the existing person
	 * @return 
	 */
	public boolean delete(Integer id) {
		logger.debug("Deleting existing person");
		boolean personNotFound = true;
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Person person = (Person) session.get(Person.class, id);
		if(person == null)
		{

			   personNotFound = false;
			   return personNotFound;
		}
			
		
		// Delete 
		session.delete(person);
		return personNotFound;
	}
	
	/**
	 * Edits an existing person
	 * @param id the id of the existing person
	 * @param firstName the first name of the existing person
	 * @param lastName the last name of the existing person
	 * @param money the money of the existing person
	 */
	public boolean edit(Person person) {
		logger.debug("Editing existing person");
		boolean personNotFound = true;
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Person dbPerson = (Person) session.get(Person.class, person.getId());
		if(dbPerson == null)
		{
		   personNotFound = false;
		   return personNotFound;
		}
		// Assign updated values to this person
		dbPerson.setFirstName(person.getFirstName());
		dbPerson.setLastName(person.getLastName());
		dbPerson.setMiddleName(person.getMiddleName());
		dbPerson.setGender(person.getGender());
		dbPerson.setAge(person.getAge());
		dbPerson.setPhone(person.getPhone());
		dbPerson.setZip(person.getZip());

		// Save updates
		session.save(person);
		return personNotFound;
	}
}
