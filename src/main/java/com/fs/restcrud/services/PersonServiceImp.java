/**
 * 
 */
package com.fs.restcrud.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.restcrud.entity.Person;
import com.fs.restcrud.repositories.ContactRepository;
import com.fs.restcrud.repositories.PersonRepository;

/**
 * @author Ghulam Murtaza
 * 
 * Aug 12, 2020
 * ghm.murtaza@gmail.com
 * 
 * This class is used for person services
 */

@Service
public class PersonServiceImp implements IPersonService{
	
	private static Logger loger = LoggerFactory.getLogger(PersonServiceImp.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void saveService(Person person) 
	{
		loger.info("create new pserson"+person.toString());
		person.setCreated(new Date());
		personRepository.save(person);
		person.getContacts().forEach(p->p.setPerson(person));
		personRepository.save(person);
		
		
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		loger.info("get all pwerons list");
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		loger.info("get pwerons list by id "+id);
		Optional<Person> optionalperson = personRepository.findById(id);
		return (optionalperson!=null?optionalperson.get():null);
		
	}

	@Override
	@Transactional
	public void deletePerson(Person person) {
		loger.info("delete personb "+person.toString());
		personRepository.delete(person);
		
	}

	@Override
	public Person getPersonByName(String name) {
		loger.info("delete personb "+name);
		return personRepository.findByName(name);
	}

	@Override
	public void updatePerson(Person person) 
	{
		loger.info("Update person "+person.getName());
		Person dbperson = getPersonById(person.getId());
		
		//dbperson.setContacts(person.getContacts());
		person.getContacts().forEach(
				c->c.setPerson(dbperson));
	
		contactRepository.saveAll(person.getContacts());
		
		dbperson.setName(person.getName());
		dbperson.setSurname(person.getSurname());
		dbperson.setAge(person.getAge());
		dbperson.setBirthday(person.getBirthday());
		dbperson.setPhone(person.getPhone());
		dbperson.setSex(person.getSex());
		
		personRepository.save(dbperson);
		
	}


}
