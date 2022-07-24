package com.monkeygarage.RoadTest.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.monkeygarage.RoadTest.bean.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

}
