package com.monkeygarage.RoadTest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.monkeygarage.RoadTest.bean.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
