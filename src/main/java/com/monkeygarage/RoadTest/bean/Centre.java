package com.monkeygarage.RoadTest.bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.monkeygarage.RoadTest.exception.AppointmentNotFoundException;
import com.monkeygarage.RoadTest.exception.SupervisorNotFoundException;
import com.monkeygarage.RoadTest.exception.VehicleNotFoundException;
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
	
	private static final String name = "Monkey Garage";

	public Centre() {
		super();
	}

	public String getName() {
		return name;
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
		List<Appointment> result = appointmentService.findByState(s);
		return result;
	}
	
	public Appointment cancel(Appointment a) throws AppointmentNotFoundException {
		Appointment ap = appointmentService.findById(a.getId()).orElseThrow(() -> new AppointmentNotFoundException(a.getId()));
		ap.setState(Appointment.AppointmentState.CANCELED);
		return ap;
	}

	public Appointment success(Appointment a) throws AppointmentNotFoundException {
		Appointment ap = appointmentService.findById(a.getId()).orElseThrow(() -> new AppointmentNotFoundException(a.getId()));
		ap.setState(Appointment.AppointmentState.SUCCESSFUL);
		return ap;
	}
	
	public Appointment fail(Appointment a) throws AppointmentNotFoundException {
		Appointment ap = appointmentService.findById(a.getId()).orElseThrow(() -> new AppointmentNotFoundException(a.getId()));
		ap.setState(Appointment.AppointmentState.FAILED);
		return ap;
	}	
	
	public Appointment accept(Appointment a, Supervisor s) throws AppointmentNotFoundException, SupervisorNotFoundException {
		Appointment ap = appointmentService.findById(a.getId()).orElseThrow(() -> new AppointmentNotFoundException(a.getId()));
		Supervisor sup = supervisorService.findById(s.getId()).orElseThrow(() -> new SupervisorNotFoundException(s.getId()));
		ap.setState(Appointment.AppointmentState.INPROGRESS);
		ap.setSupervisor(sup);
		return ap;
	}
	
	public List<Appointment> getHistory(Long id) throws VehicleNotFoundException {
		Vehicle v = vehicleService.findById(id).orElseThrow(() -> new VehicleNotFoundException(id)); 
		return appointmentService.findByVehicle(v.getId());
	}
}
