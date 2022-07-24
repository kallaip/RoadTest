package com.monkeygarage.RoadTest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.monkeygarage.RoadTest.bean.Owner;
import com.monkeygarage.RoadTest.exception.OwnerNotFoundException;
import com.monkeygarage.RoadTest.service.OwnerRepository;

@RestController
public class OwnerController {
	
	@Autowired
	private OwnerRepository service;
	
	// GET /owners
	@GetMapping("/owners")
	public List<Owner> getOwnersList()
	{
		return service.findAll();
	}
	
		
	//GET /owners/{id}
	@GetMapping("/owners/{id}")
	public EntityModel<Owner> getOwner(@PathVariable Long id)
	{
		Owner owner = service.findById(id).orElseThrow(() -> new OwnerNotFoundException(id));

		EntityModel<Owner> model = EntityModel.of(owner);
		WebMvcLinkBuilder linkToOwners = linkTo(methodOn(this.getClass()).getOwnersList());
		model.add(linkToOwners.withRel("all-owners"));
		
		return model;
	}
}