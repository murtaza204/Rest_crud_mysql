package com.fs.restcrud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fs.restcrud.entity.Person;
import com.fs.restcrud.services.IPersonService;
import com.fs.restcrud.utils.TestStatic;

/**
 * @author Ghulam Murtaza
 * 
 * @since Aug 12, 2020
 * ghm.murtaza@gmail.com
 * This class is used to handle all rest full requests.
 *  
 */

@RestController
public class RestCrudController {
	
	private static Logger loger = LoggerFactory.getLogger(RestCrudController.class);
	/**
	 * @author Ghulam Murtaza
	 * @return
	 * 
	 * this function is used to test the api.
	 * 
	 */
	
	@Autowired
	private IPersonService iPersonService;
	
	private TestStatic testStatic=null;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test()
	{
		loger.info("test path");
		return testStatic.TESTSTRING;//"fine here murtaza";
	}
	
	/**
	 * 
	 * @return
	 * 
	 * this method is used to save the new person
	 */
	
	@RequestMapping(value = "/createperson", method = RequestMethod.POST)
	public String createPerson(@RequestBody Person person)
	{
		loger.info("create new user");
		if(person.getName().isEmpty() )
		{
			loger.info("user is empty");
			return "Name is empty";
		}
		else
		if(person.getSurname().isEmpty())
		{
			loger.info("user sure name is empty");
			return "sure Name is empty";
		}
		
		iPersonService.saveService(person);
		return "Person created Sucessfully";
	}
	
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 13 2020
	 * @param person
	 * @return
	 * 
	 * This method is used to update the person
	 */
	
	@RequestMapping(value = "/updateperson", method = RequestMethod.POST)
	public String updatePerson(@RequestBody Person person)
	{
		loger.info("update user");
		if(person.getName().isEmpty() ) {
			loger.info("user is empty");
			return "Name is empty";
		}
		else
		if(person.getSurname().isEmpty())
		{
			loger.info("sure name is empty");
			return "sure Name is empty";
		}
		
		iPersonService.updatePerson(person);
		
		loger.info("User undated sucessfully");
		return "update person Sucessfully";
	}
	
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 13 2020
	 * @return
	 * 
	 * This method is used to get the all persons list
	 */
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public List<Person> getPersons()
	{
		loger.info("get Persons list");
		return	iPersonService.getAllPersons();
		
	}
	
	@RequestMapping(value = "/personswithpage", method = RequestMethod.GET)
	public Page<Person> getPersons(int startIdex, int maxresult)
	{
		loger.info("get Persons list");
		
		if(maxresult ==0)
			maxresult=5;
		
		return	iPersonService.getAllPagablePersons(startIdex, maxresult);
		
	}
	
	/**
	 * @author Ghulam Murtaza
	 * @param id
	 * @return
	 * @since Aug 13 2020
	 * 
	 * This method is sued to delete the persons records in the db
	 * 
	 */
	
	@RequestMapping(value = "/deleteperson/{id}", method = RequestMethod.DELETE)
	public String getPersons(@PathVariable Long  id)
	{
		Person person = iPersonService.getPersonById(id);
		loger.info("person is deleted");
		if(person!=null)
		{
			loger.info("person is not exist");
			iPersonService.deletePerson(person);
			return "Person deleted";
		}
		else
		{
			loger.info("person deleted sucessfully");
			return "Person does not exist";
		}

	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * 
	 * This function is used to get Person by name
	 */

	@RequestMapping(value = "/getpersonbyname/{name}", method = RequestMethod.GET)
	public Person getPersonsByName(@PathVariable String  name)
	{
		loger.info("Get Person by Name");
		return iPersonService.getPersonByName(name);

	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * 
	 * This person is used to get Person by ID
	 * 
	 */
	
	@RequestMapping(value = "/getpersonbyid/{id}", method = RequestMethod.GET)
	public Person getPersonById(@PathVariable Long  id)
	{
		Person person = iPersonService.getPersonById(id);
		loger.info("person is deleted");
		return person;
	}
}
