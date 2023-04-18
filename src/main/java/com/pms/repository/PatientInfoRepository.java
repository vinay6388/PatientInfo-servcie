package com.pms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.PatientInfo;

public interface PatientInfoRepository extends JpaRepository<PatientInfo, String> {
	
	
	
	public PatientInfo findByPatientId(String patientId);	
	
	public boolean existsById(String patientId);


}
