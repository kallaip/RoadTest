package com.monkeygarage.RoadTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.monkeygarage.RoadTest.bean.Owner;
import com.monkeygarage.RoadTest.service.OwnerRepository;
	
@Component
public class DemoDataCommandlineRunner implements CommandLineRunner {

	@Autowired
	private OwnerRepository service;
	
	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Doe");
		service.save(owner1);
		
		Owner owner2 = new Owner("Jane", "Doe");
		service.save(owner2);
	}
}
