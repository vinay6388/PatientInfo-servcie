package com.pms.service;

import java.util.List;

import com.pms.entity.PatientInfo;
import com.pms.exception.PatientServiceException;

public interface PatientInfoService {
	
	public PatientInfo updateDetails(PatientInfo patientinfo , String patientId)throws PatientServiceException;
	public PatientInfo getpatientinfo(String patientId)throws PatientServiceException;
	public List<PatientInfo> showAllAvailability()throws PatientServiceException;
	//public PatientInfo saveDetails(PatientInfo patientinfo);

}
