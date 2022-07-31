package com.thalasoft.learnintouch.data.exception;

@SuppressWarnings("serial")
public class AdminAlreadyExistsException extends EnrichableException {

    String email;
    
	public AdminAlreadyExistsException(String email) {
	    super("The admin with email " + email + " already exists.");
	    this.email = email;
	}

	public String getEmail() {
	  return email;
	}
	
}