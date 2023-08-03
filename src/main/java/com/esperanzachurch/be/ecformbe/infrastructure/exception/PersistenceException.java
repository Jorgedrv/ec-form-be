package com.esperanzachurch.be.ecformbe.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PersistenceException extends RuntimeException {

	/**
	 * Serial version generated
	 */
	private static final long serialVersionUID = -2566378532377853990L;

	/**
	 * Constructor
	 *
	 * @param message text with the exception description
	 * @param cause   throwable with the trace of the exception
	 */
	public PersistenceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 *
	 * @param message text with the exception description
	 */
	public PersistenceException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause throwable with the trace of the exception
	 */
	public PersistenceException(final Throwable cause) {
		super(cause);
	}

}
