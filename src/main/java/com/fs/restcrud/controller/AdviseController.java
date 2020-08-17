/**
 * 
 */
package com.fs.restcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fs.restcrud.utils.ResponseStatus;

/**
 * @author Ghulam Murtaza
 * 
 * @since Aug 12, 2020
 * ghm.murtaza@gmail.com
 * This class is used to handle all exceptions of rest controller.
 *  
 */

@RestControllerAdvice
public class AdviseController
{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseStatus> GetException(Exception e)
	{
		 
		 return new ResponseEntity<ResponseStatus>(new ResponseStatus(e.getMessage(),HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
	}

}
