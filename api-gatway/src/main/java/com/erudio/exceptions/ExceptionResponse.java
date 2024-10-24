package com.erudio.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timesstamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timesstamp, String message, String details) {
		this.timesstamp = timesstamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimesstamp() {
		return timesstamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}	
	
}
