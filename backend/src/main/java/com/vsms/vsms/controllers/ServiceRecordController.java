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

import com.vsms.vsms.dto.ServiceRecordDTO;
import com.vsms.vsms.entity.ServiceRecord;
import com.vsms.vsms.services.ServiceRecordService;

@RestController
@RequestMapping("/servicerecords")
public class ServiceRecordController {
	@Autowired
	private ServiceRecordService serv_serv;

	@PostMapping("/save")
	public String saveRecord(@RequestBody ServiceRecordDTO dto) {
		serv_serv.saveRecord(dto);
		return "Service record saved successfully!";
	}

	@GetMapping("/getAll")
	public List<ServiceRecord> getAll(){
		return serv_serv.getAllRecords();
	}

	@GetMapping("/get/{id}")
	public Optional<ServiceRecord> getRecord(@PathVariable Long id) {
		return serv_serv.getRecord(id);
	}

	@PutMapping("/update")
	public ServiceRecord updateRecord(@RequestBody ServiceRecord rec) {
		return serv_serv.updateRecord(rec);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRecord(@PathVariable Long id) {
		serv_serv.deleteRecord(id);
		return "Service record deleted successfully!";
	}

}
