package com.monkeygarage.RoadTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monkeygarage.RoadTest.bean.Appointment;
import com.monkeygarage.RoadTest.bean.Centre;
import com.monkeygarage.RoadTest.bean.Owner;
import com.monkeygarage.RoadTest.bean.Supervisor;
import com.monkeygarage.RoadTest.bean.Vehicle;
import com.monkeygarage.RoadTest.service.AppointmentRepository;
import com.monkeygarage.RoadTest.service.SupervisorRepository;
import com.monkeygarage.RoadTest.service.VehicleRepository;

@RestController
public class CentreController {
	
	@Autowired
	AppointmentRepository aS;
	
	@Autowired
	SupervisorRepository sS;
	
	@Autowired
	VehicleRepository vS;
	
	// POST /schedule
	@PostMapping("/schedule")
	Appointment scheduleAppointment(@RequestBody Vehicle v) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.schedule(v);
	}
	
	// POST /signup
	@PostMapping("/signup")
	Owner signupOwner(@RequestBody Owner o) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.signup(o.getFirstName(), o.getLastName());
	}
	
	// POST /employ
	@PostMapping("/employ")
	Supervisor employSupervisor(@RequestBody Supervisor s) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.employ(s.getName());
	}
	
	// POST /employ
	@PostMapping("/unemploy")
	void unemploySupervisor(@RequestBody Supervisor s) {
		Centre centre = new Centre(aS, sS, vS);
		centre.unemploy(s);
	}
	
	// GET /appointments/new
	@GetMapping("/appointments/new")
	public List<Appointment> getNewAppointments() {
		Centre centre = new Centre(aS, sS, vS);
		return centre.listByStatus(Appointment.AppointmentState.NEW);
	}
	
	// GET /appointments/inprogress
	@GetMapping("/appointments/inprogress")
	public List<Appointment> getInProgressAppointments() {
		Centre centre = new Centre(aS, sS, vS);
		return centre.listByStatus(Appointment.AppointmentState.INPROGRESS);
	}
	
	// GET /appointments/canceled
	@GetMapping("/appointments/canceled")
	public List<Appointment> getCanceledAppointments() {
		Centre centre = new Centre(aS, sS, vS);
		return centre.listByStatus(Appointment.AppointmentState.CANCELED);
	}
	
	// GET /appointments/successful
	@GetMapping("/appointments/successful")
	public List<Appointment> getSuccessfulAppointments() {
		Centre centre = new Centre(aS, sS, vS);
		return centre.listByStatus(Appointment.AppointmentState.SUCCESSFUL);
	}
	
	// GET /appointments/failed
	@GetMapping("/appointments/failed")
	public List<Appointment> getFailedAppointments() {
		Centre centre = new Centre(aS, sS, vS);
		return centre.listByStatus(Appointment.AppointmentState.FAILED);
	}
	
	// PUT /cancel
	@PutMapping("/cancel")
	Appointment cancelAppointment(@RequestBody Appointment a) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.cancel(a);
	}

	// PUT /success
	@PutMapping("/success")
	Appointment successAppointment(@RequestBody Appointment a) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.success(a);
	}

	// PUT /fail
	@PutMapping("/fail")
	Appointment failAppointment(@RequestBody Appointment a) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.fail(a);
	}
	
	// PUT /accept
	@PutMapping("/accept")
	Appointment acceptAppointment(@RequestBody Appointment a, @RequestBody Supervisor s) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.accept(a, s);
	}
	
	//GET /vehiclehistory/{id}
	@GetMapping("/vehiclehistory/{id}")
	public List<Appointment> getFailedAppointments(@PathVariable Long id) {
		Centre centre = new Centre(aS, sS, vS);
		return centre.getHistory(id);
	}
}
