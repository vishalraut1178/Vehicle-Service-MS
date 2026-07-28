package com.vsms.vsms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsms.vsms.dto.VehicleDTO;
import com.vsms.vsms.entity.Customer;
import com.vsms.vsms.entity.Vehicle;
import com.vsms.vsms.repositories.CustomerRepo;
import com.vsms.vsms.repositories.VehicleRepo;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepo veh_repo;

	@Autowired
	private CustomerRepo cust_repo;

	public void saveVehicle(VehicleDTO dto) {
		Customer owner = cust_repo.getById(dto.getCustomerId());

		Vehicle veh = new Vehicle();
		veh.setRegistrationNumber(dto.getRegistrationNumber());
		veh.setBrand(dto.getBrand());
		veh.setModel(dto.getModel());
		veh.setManufacturingYear(dto.getManufacturingYear());
		veh.setOwner(owner);

		veh_repo.save(veh);
	}

	public List<Vehicle> getAllVehicles(){
		return veh_repo.findAll();
	}

	public Optional<Vehicle> getVehicle(Long id) {
		return veh_repo.findById(id);
	}

	public Vehicle updateVehicle(Vehicle veh) {
		Vehicle old_veh = veh_repo.getById(veh.getId());

		old_veh.setRegistrationNumber(veh.getRegistrationNumber());
		old_veh.setBrand(veh.getBrand());
		old_veh.setModel(veh.getModel());
		old_veh.setManufacturingYear(veh.getManufacturingYear());

		veh_repo.save(old_veh);
		return old_veh;
	}

	public void deleteVehicle(Long id) {
		veh_repo.deleteById(id);
	}
}
