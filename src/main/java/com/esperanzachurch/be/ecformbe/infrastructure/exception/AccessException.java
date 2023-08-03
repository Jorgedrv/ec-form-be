package com.esperanzachurch.be.ecformbe.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AccessException extends RuntimeException {

	/**
	 * Serial version generated
	 */
	private static final long serialVersionUID = 5049577350617160022L;

	/**
	 * Constructor
	 *
	 * @param message text with the exception description
	 * @param cause   throwable with the trace of the exception
	 */
	public AccessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 *
	 * @param message text with the exception description
	 */
	public AccessException(final String message) {
		super(message);
	}

	/**
	 * Constructor
	 *
	 * @param cause throwable with the trace of the exception
	 */
	public AccessException(final Throwable cause) {
		super(cause);
	}

}
