package com.monkeygarage.RoadTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9220342838016539385L;

	public VehicleNotFoundException(Long id) {
		super("Could not find vehicle: " + id);
	}
}
