/**
 * 
 */
package com.fs.restcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs.restcrud.entity.Person;

/**
 * @author Ghulam Murtaza
 * 
 * Aug 12, 2020
 * ghm.murtaza@gmail.com
 * Company fortsolution.com 
 */

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	
	public Person findByName(String name);

}
