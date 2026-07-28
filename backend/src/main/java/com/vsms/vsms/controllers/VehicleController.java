package com.vsms.vsms.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsms.vsms.dto.VehicleDTO;
import com.vsms.vsms.entity.Vehicle;
import com.vsms.vsms.services.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService veh_serv;

	@PostMapping("/save")
	public String saveVehicle(@RequestBody VehicleDTO dto) {
		veh_serv.saveVehicle(dto);
		return "Vehicle saved successfully!";
	}

	@GetMapping("/getAll")
	public List<Vehicle> getAll(){
		return veh_serv.getAllVehicles();
	}

	@GetMapping("/get/{id}")
	public Optional<Vehicle> getVehicle(@PathVariable Long id) {
		return veh_serv.getVehicle(id);
	}

	@PutMapping("/update")
	public Vehicle updateVehicle(@RequestBody Vehicle veh) {
		return veh_serv.updateVehicle(veh);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteVehicle(@PathVariable Long id) {
		veh_serv.deleteVehicle(id);
		return "Vehicle deleted successfully!";
	}

}
