package com.esperanzachurch.be.ecformbe.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * Serial version generated
	 */
	private static final long serialVersionUID = -5404609044212031512L;

	/**
	 * Constructor
	 *
	 * @param message text with the exception description
	 * @param cause   throwable with the trace of the exception
	 */
	public NotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 *
	 * @param message text with the exception description
	 */
	public NotFoundException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause throwable with the trace of the exception
	 */
	public NotFoundException(final Throwable cause) {
		super(cause);
	}

}
