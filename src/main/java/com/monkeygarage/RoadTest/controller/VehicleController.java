package com.monkeygarage.RoadTest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.monkeygarage.RoadTest.bean.Vehicle;
import com.monkeygarage.RoadTest.exception.VehicleNotFoundException;
import com.monkeygarage.RoadTest.service.VehicleRepository;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleRepository service;
	
	// GET /vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> getVehicleList()
	{
		return service.findAll();
	}

	//GET /vehicles/{id}
	@GetMapping("/vehicles/{id}")
	public EntityModel<Vehicle> getVehicle(@PathVariable Long id)
	{
		Vehicle vehicle = service.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));

		EntityModel<Vehicle> model = EntityModel.of(vehicle);
		WebMvcLinkBuilder linkToVehicles = linkTo(methodOn(this.getClass()).getVehicleList());
		model.add(linkToVehicles.withRel("all-vehicles"));
		return model;
	}
}
