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
import com.monkeygarage.RoadTest.bean.Appointment;
import com.monkeygarage.RoadTest.exception.AppointmentNotFoundException;
import com.monkeygarage.RoadTest.service.AppointmentRepository;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentRepository service;
	
	// GET /appointments
	@GetMapping("/appointments")
	public List<Appointment> getAppointmentList()
	{
		return service.findAll();
	}
	
	//GET /appointments/{id}
	@GetMapping("/appointments/{id}")
	public EntityModel<Appointment> getAppointment(@PathVariable Long id)
	{
		Appointment appointment = service.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));

		EntityModel<Appointment> model = EntityModel.of(appointment);
		WebMvcLinkBuilder linkToAppointments = linkTo(methodOn(this.getClass()).getAppointmentList());
		model.add(linkToAppointments.withRel("all-owners"));
		
		return model;
	}	
	
	
}
