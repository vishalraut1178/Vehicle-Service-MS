package com.vsms.vsms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsms.vsms.entity.ServiceRecord;

@Repository
public interface ServiceRecordRepo extends JpaRepository<ServiceRecord, Long> {

}
