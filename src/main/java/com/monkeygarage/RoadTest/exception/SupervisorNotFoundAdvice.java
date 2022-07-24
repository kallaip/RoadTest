package com.monkeygarage.RoadTest.exception;

import java.util.Date;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SupervisorNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(SupervisorNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	EntityModel<ExceptionResponse> supervisorNotFoundHandler(SupervisorNotFoundException ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return EntityModel.of(exceptionResponse);
	}
}
