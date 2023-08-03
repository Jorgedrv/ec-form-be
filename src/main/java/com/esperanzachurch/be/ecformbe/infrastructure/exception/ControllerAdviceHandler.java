package com.esperanzachurch.be.ecformbe.infrastructure.exception;

import com.esperanzachurch.be.ecformbe.infrastructure.exception.domain.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerAdviceHandler extends ResponseEntityExceptionHandler {

	private static final LocalDateTime LOCAL_DATE = LocalDateTime.now();

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> internalErrorException(Exception ex, WebRequest request) {
		HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
		String status = ex.getCause().getMessage().substring(0, 3);
		switch (status) {
			case "400": {
				internalServerError = HttpStatus.BAD_REQUEST;
				break;
			}
			case "401": {
				internalServerError = HttpStatus.UNAUTHORIZED;
				break;
			}
			case "404": {
				internalServerError = HttpStatus.NOT_FOUND;
				break;
			}
		}
		return getInternalErrorServer((ServletWebRequest) request, internalServerError, ex.getCause().getMessage());
	}

	private ResponseEntity<ErrorResponse> getInternalErrorServer(
			ServletWebRequest request, HttpStatus internalServerError, String message) {
		HttpStatus status = internalServerError;
		ErrorResponse error = ErrorResponse.builder()
				.code(status.value())
				.description(message)
				.status(status)
				.path(request.getRequest().getRequestURI())
				.method(request.getRequest().getMethod())
				.timeStamp(LOCAL_DATE)
				.build();
		return new ResponseEntity<>(error, status);
	}

}
