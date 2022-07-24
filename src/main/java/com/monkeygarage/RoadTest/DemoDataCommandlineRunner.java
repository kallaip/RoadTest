package com.monkeygarage.RoadTest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.monkeygarage.RoadTest.bean.Appointment;
import com.monkeygarage.RoadTest.bean.Owner;
import com.monkeygarage.RoadTest.bean.Supervisor;
import com.monkeygarage.RoadTest.bean.Vehicle;
import com.monkeygarage.RoadTest.service.AppointmentRepository;
import com.monkeygarage.RoadTest.service.OwnerRepository;
import com.monkeygarage.RoadTest.service.SupervisorRepository;
import com.monkeygarage.RoadTest.service.VehicleRepository;
	
@Component
public class DemoDataCommandlineRunner implements CommandLineRunner {

	@Autowired
	private OwnerRepository ownerService;
	
	@Autowired
	private VehicleRepository vehicleService;
	
	@Autowired
	private SupervisorRepository supervisorService;
	
	@Autowired
	private AppointmentRepository appointmentService;
	
	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Doe");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner("Jane", "Doe");
		ownerService.save(owner2);
		
		Vehicle v1 = new Vehicle("ABC-123", "Opel", owner1);
		vehicleService.save(v1);
		Vehicle v2 = new Vehicle("IDK-42", "Ford", owner1);
		vehicleService.save(v2);
		Vehicle v3 = new Vehicle("OMG-444", "Tesla", owner2);
		vehicleService.save(v3);
		
		Supervisor s1 = new Supervisor("Joe Picky");
		supervisorService.save(s1);
		Supervisor s2 = new Supervisor("Mathilda Cloud");
		supervisorService.save(s2);
		Supervisor s3 = new Supervisor("Devon Dirty");
		supervisorService.save(s3);
		
		Appointment a1 = new Appointment(new Date(), v1, s2);
		appointmentService.save(a1);
		Appointment a2 = new Appointment(new Date(), v3, s3);
		appointmentService.save(a2);
		
	}
}
