package com.monkeygarage.RoadTest.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monkeygarage.RoadTest.bean.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
