package org.spring.hibernate.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;

import org.apache.log4j.Logger;
import org.spring.hibernate.test.entity.Person;
import org.spring.hibernate.test.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles and retrieves person request
 */
@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "personService")
	private PersonService personService;

	/**
	 * Handles and retrieves all persons and show it in a JSP page
	 * 
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getPersons() {

		logger.debug("Received request to show all persons");

		// Retrieve all persons by delegating the call to PersonService
		List<Person> persons = personService.getAll();
		return new ResponseEntity(persons, HttpStatus.OK);
	}

	/**
	 * Adds a new person by delegating the processing to PersonService. Displays
	 *
	 * 
	 * @return ResponseEntity
	 */

	@Consumes("application/json")
	@RequestMapping(value = "/persons/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody Person person) {

		logger.debug("Received request to add new person");

		// Call PersonService to do the actual adding
		personService.add(person);

		// This will resolve to /WEB-INF/jsp/addedpage.jsp
		return new ResponseEntity("Person Added Successfully", HttpStatus.OK);

	}

	/**
	 * Deletes an existing person by delegating the processing to PersonService.
	 * 
	 * 
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/persons/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> delete(@RequestParam(value = "id", required = true) Integer id) {

		logger.debug("Received request to delete existing person");

		// Call PersonService to do the actual deleting
		if (personService.delete(id))
			return new ResponseEntity(id + "deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity("Member Not Found", HttpStatus.NOT_FOUND);
	}

	/**
	 * Edits an existing person by delegating the processing to PersonService.
	 *
	 * 
	 * @param person
	 * 
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/persons/edit", method = RequestMethod.PUT)
	public ResponseEntity edit(@RequestBody Person person) {

		logger.debug("Received request to edit existing person");

		// Call PersonService to do the actual editing
		if (personService.edit(person))
			return new ResponseEntity("Updated successfully", HttpStatus.OK);
		else
			return new ResponseEntity("Member Not Found", HttpStatus.NOT_FOUND);

	}
}
