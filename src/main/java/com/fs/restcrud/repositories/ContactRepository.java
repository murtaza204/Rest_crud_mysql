/**
 * 
 */
package com.fs.restcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fs.restcrud.entity.Contact;
import com.fs.restcrud.entity.Person;

/**
 * @author Ghulam Murtaza
 * 
 * Aug 15, 2020
 * ghm.murtaza@gmail.com
 *  
 */
public interface ContactRepository  extends JpaRepository<Contact, Long>{

}
