package com.monkeygarage.RoadTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppointmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3105038553447574989L;

	public AppointmentNotFoundException(Long id) {
		super("Could not find appointment: " + id);
	}
}
