package com.monkeygarage.RoadTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3319305905250974940L;

	public OwnerNotFoundException(Long id) {
		super("Could not find owner: " + id);
	}
}
