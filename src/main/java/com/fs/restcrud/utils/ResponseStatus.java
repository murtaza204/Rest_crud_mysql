/**
 * 
 */
package com.fs.restcrud.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ghulam Murtaza
 * 
 * @since Aug 12, 2020
 * ghm.murtaza@gmail.com
 * 
 * This class is used to return the response if the exception occur at any place.
 */
@Getter
@Setter

public class ResponseStatus {
	
	private int code;
	private String message;

	public ResponseStatus(String message,int code)
	{
		this.code = code;
		this.message = message;
	}
}
