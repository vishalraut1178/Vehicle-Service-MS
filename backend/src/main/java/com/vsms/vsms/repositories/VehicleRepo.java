package com.vsms.vsms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsms.vsms.entity.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

}
