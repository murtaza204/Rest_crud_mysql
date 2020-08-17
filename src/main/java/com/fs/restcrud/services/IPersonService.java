/**
 * 
 */
package com.fs.restcrud.services;

import java.util.List;

import com.fs.restcrud.entity.Person;

/**
 * @author Ghulam Murtaza
 * Aug 12, 2020
 * ghm.murtaza@gmail.com
 *
 */
public interface IPersonService 
{
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 12, 2020
	 * ghm.murtaza@gmail.com
	 * @param person
	 * 
	 * This method is sued to save the Person data in the database
	 */
	public void saveService(Person person);
	
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 12, 2020
	 * ghm.murtaza@gmail.com
	 * @return List<Person>
	 * 
	 * This method is used to get all persons list from database.
	 */
	public List<Person> getAllPersons();
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 12, 2020
	 * ghm.murtaza@gmail.com
	 * @param id
	 * @return Person
	 * 
	 * this method is used to get person by id
	 */
	public Person getPersonById(Long id);
	
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 12, 2020
	 * ghm.murtaza@gmail.com
	 * @param person
	 * 
	 * this method is used the delete the person
	 */
	public void deletePerson(Person person);
	
	/**
	 * @author Ghuam Murtaza
	 * @since aug 13 2020
	 * @param person
	 * 
	 * this function is update Person's data
	 */
	
	public void updatePerson(Person person);
	
	/**
	 * @author Ghulam Murtaza
	 * @since Aug 12, 2020
	 * ghm.murtaza@gmail.com
	 * @param name
	 * @return
	 * This method is used to get the person by name
	 */
	public Person getPersonByName(String name);
}
