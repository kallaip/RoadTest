package com.monkeygarage.RoadTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SupervisorNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = -2302649796666826595L;

	public SupervisorNotFoundException(Long id) {
		super("Could not find supervisor: " + id);
	}
}
