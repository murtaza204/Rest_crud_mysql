/**
 * 
 */
package com.fs.restcrud.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ghulam Murtaza
 * 
 * Aug 13, 2020
 * murtaza@fortsolution.com
 * Company fortsolution.com 
 * 
 * This class is used to save the Contact in the contact table.
 * 
 */

@Entity
@Getter
@Setter
@JsonIgnoreProperties

public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String Name;
	
	private String phonenubmer;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

}
