package com.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.PatientInfo;
import com.pms.exception.PatientServiceException;
import com.pms.repository.PatientInfoRepository;
import com.pms.service.PatientInfoService;

@Service
public class PatientInfoServiceImpl implements PatientInfoService {

	@Autowired
	public PatientInfoRepository patientInfoRepository;

	/*
	 * // Service for insert data ,optional
	 * 
	 * @Override public PatientInfo saveDetails(PatientInfo patientinfo) { return
	 * patientinforepository.save(patientinfo); }
	 */

	// service for updating patient info
	@Override
	public PatientInfo updateDetails(PatientInfo patientInfo, String patientId) throws PatientServiceException {
		
		boolean bool = patientInfoRepository.existsById(patientId);
		if(!bool) {
			throw new PatientServiceException("Given patient Id does not exist "+patientId);
		}
		
		patientInfo.setPatientId(patientId);
		PatientInfo result = patientInfoRepository.save(patientInfo);
		return result;
	}

	// Service for fetching patient info with the help of Id
	@Override
	public PatientInfo getpatientinfo(String patientId) throws PatientServiceException {
		PatientInfo patientinfo = null;
		patientinfo = (PatientInfo) this.patientInfoRepository.findByPatientId(patientId);
		System.out.println("Patient IDc: "+patientId);
		
		if(patientinfo == null)
			throw new PatientServiceException("Given patient Id does not exist "+patientId);
		
		
		return patientinfo;
	}

	// fetching all the patients info , for admin only
	@Override
	public List<PatientInfo> showAllAvailability() throws PatientServiceException {
		List<PatientInfo> list = (List<PatientInfo>) this.patientInfoRepository.findAll();
		
		if(list == null)
			throw new PatientServiceException("Patient information does not exist ");
		
		return list;
	}
}