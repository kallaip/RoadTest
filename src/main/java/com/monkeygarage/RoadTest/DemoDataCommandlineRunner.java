package com.monkeygarage.RoadTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.monkeygarage.RoadTest.bean.Owner;
import com.monkeygarage.RoadTest.bean.Vehicle;
import com.monkeygarage.RoadTest.service.OwnerRepository;
import com.monkeygarage.RoadTest.service.VehicleRepository;
	
@Component
public class DemoDataCommandlineRunner implements CommandLineRunner {

	@Autowired
	private OwnerRepository ownerService;
	
	@Autowired
	private VehicleRepository vehicleService;
	
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
		
	}
}
