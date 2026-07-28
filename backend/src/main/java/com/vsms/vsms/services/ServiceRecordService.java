package com.vsms.vsms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsms.vsms.dto.ServiceRecordDTO;
import com.vsms.vsms.entity.ServiceRecord;
import com.vsms.vsms.entity.Vehicle;
import com.vsms.vsms.repositories.ServiceRecordRepo;
import com.vsms.vsms.repositories.VehicleRepo;

@Service
public class ServiceRecordService {
	@Autowired
	private ServiceRecordRepo serv_repo;

	@Autowired
	private VehicleRepo veh_repo;

	public void saveRecord(ServiceRecordDTO dto) {
		Vehicle veh = veh_repo.getById(dto.getVehicleId());

		ServiceRecord rec = new ServiceRecord();
		rec.setServiceType(dto.getServiceType());
		rec.setDescription(dto.getDescription());
		rec.setServiceCost(dto.getServiceCost());
		rec.setStatus(dto.getStatus());
		rec.setVehicle(veh);

		serv_repo.save(rec);
	}

	public List<ServiceRecord> getAllRecords(){
		return serv_repo.findAll();
	}

	public Optional<ServiceRecord> getRecord(Long id) {
		return serv_repo.findById(id);
	}

	public ServiceRecord updateRecord(ServiceRecord rec) {
		ServiceRecord old_rec = serv_repo.getById(rec.getId());

		old_rec.setServiceType(rec.getServiceType());
		old_rec.setDescription(rec.getDescription());
		old_rec.setServiceCost(rec.getServiceCost());
		old_rec.setStatus(rec.getStatus());
		old_rec.setServiceDate(rec.getServiceDate());

		serv_repo.save(old_rec);
		return old_rec;
	}

	public void deleteRecord(Long id) {
		serv_repo.deleteById(id);
	}
}
