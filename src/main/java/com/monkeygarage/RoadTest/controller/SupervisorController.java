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
import com.monkeygarage.RoadTest.bean.Supervisor;
import com.monkeygarage.RoadTest.exception.SupervisorNotFoundException;
import com.monkeygarage.RoadTest.service.SupervisorRepository;

@RestController
public class SupervisorController {
	@Autowired
	private SupervisorRepository service;
	
	// GET /owners
	@GetMapping("/supervisors")
	public List<Supervisor> getSupervisorList()
	{
		return service.findAll();
	}
	//GET /supervisors/{id}
		@GetMapping("/supervisors/{id}")
		public EntityModel<Supervisor> getSupervisor(@PathVariable Long id)
		{
			Supervisor supervisor = service.findById(id).orElseThrow(() -> new SupervisorNotFoundException(id));

			EntityModel<Supervisor> model = EntityModel.of(supervisor);
			WebMvcLinkBuilder linkToSupervisors = linkTo(methodOn(this.getClass()).getSupervisorList());
			model.add(linkToSupervisors.withRel("all-supervisors"));
			
			return model;
		}
}
