package com.javacruitment.rest.service.aop;

import com.javacruitment.common.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
class RestExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<Problem> handleNotFound(UserNotFoundException ex) {
		return handleException(ex, HttpStatus.NOT_FOUND);
	}

	private ResponseEntity<Problem> handleException(Exception exception, HttpStatus httpStatus) {
		log.error(exception.getMessage(), exception);

		Problem problem = new Problem(httpStatus.value(), httpStatus.getReasonPhrase(), exception.getMessage());
		return ResponseEntity.status(httpStatus)
				.contentType(MediaType.APPLICATION_PROBLEM_JSON)
				.body(problem);
	}
}
