package com.monkeygarage.RoadTest.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monkeygarage.RoadTest.bean.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
