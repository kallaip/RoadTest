package com.monkeygarage.RoadTest.bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.monkeygarage.RoadTest.exception.SupervisorNotFoundException;
import com.monkeygarage.RoadTest.service.AppointmentRepository;
import com.monkeygarage.RoadTest.service.SupervisorRepository;
import com.monkeygarage.RoadTest.service.VehicleRepository;

public class Centre {
	
	@Autowired
	AppointmentRepository appointmentService;
	@Autowired
	SupervisorRepository supervisorService;
	@Autowired
	VehicleRepository vehicleService;
	
	private String name;

	public Centre(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Centre [name=" + name + "]";
	}
	
	private Date getAppointmentDate() {
		Date dt = new Date();
		LocalDateTime.from(dt.toInstant()).plusDays(5);
		return dt;
	}
	
	public Appointment schedule(Vehicle v) {
		return new Appointment(getAppointmentDate(), v, null);
	}
	
	public Owner signup(String firstName, String lastName) {
		return new Owner(firstName, lastName);
	}
	
	public Supervisor employ(String name) {
		return new Supervisor(name);
	}
	
	public void unemploy(Supervisor s) throws SupervisorNotFoundException {
		Supervisor supervisor = supervisorService.findById(s.getId()).orElseThrow(() -> new SupervisorNotFoundException(s.getId()));
		supervisor.setInactive(true);
		supervisorService.save(supervisor);
	}
	
	public List<Appointment> listByStatus(Appointment.AppointmentState s){
		List<Appointment> result = this.appointmentService.findByState(s);
		return result;
	}
	
}
