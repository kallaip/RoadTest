package com.monkeygarage.RoadTest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.monkeygarage.RoadTest.bean.Appointment;
import com.monkeygarage.RoadTest.bean.Vehicle;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("SELECT a FROM Appointment a WHERE a.state=?1")
	List<Appointment> findByState(Appointment.AppointmentState s);
	
	@Query("SELECT a FROM Appointment a WHERE a.Vehicle_Id=?1 ORDER BY Date DESC")
	List<Appointment> findByVehicle(Long id); 
	
}
