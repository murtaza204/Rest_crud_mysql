
package com.fs.restcrud.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Ghulam Murtaza
 * Aug 12, 2020
 * This class is a persistence class that is used save, update and retrieve 
 * 
 */


@Entity
@Getter
@Setter
@JsonIgnoreProperties
public class Person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotNull(message="Name is empty")
	@Size(min=1,message="Name is empty")  
	private String name;
	@NotNull(message="Sur Name is empty")
	@Size(min=1,message="Sur Name is empty") 
	private String  surname;
	
	private int  age;
	private String  sex;
	private String  birthday;
	private String  phone;
	private String  email;
	
		
	private Date created;
	
	 @UpdateTimestamp
	 private Date modified;
	 
	/* @OneToMany(
			 	mappedBy = "person",
		        cascade = CascadeType.MERGE,
		        orphanRemoval = true
		    )
	private List<Contact> contacts;*/
	 
	 	@JsonIgnore
	    @ManyToOne(cascade={CascadeType.ALL})    
	    @JoinColumn(name = "person_id")
	    private Person parent;

	    @OneToMany(mappedBy = "parent",cascade=CascadeType.ALL)
	    private Set<Person> contacts;
	 
	 

}
