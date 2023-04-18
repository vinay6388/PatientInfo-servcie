package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.PatientInfo;
import com.pms.exception.PatientServiceException;
import com.pms.service.PatientInfoService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")
public class PatientInfoController {

	@Autowired
	public PatientInfoService patientinfoservice;

	/*
	 * // this is optional just for data
	 * 
	 * @PostMapping("/post") public PatientInfo postDetails(@RequestBody PatientInfo
	 * patientinfo) { return patientinfoservice.saveDetails(patientinfo); }
	 */

	// to update an patient info with the help of id
	@PutMapping("/patient")
	public ResponseEntity<PatientInfo> updateDetails(@RequestBody PatientInfo patientinfo,
			@RequestParam(value = "patientId") String patientId) throws PatientServiceException {
		PatientInfo pat = null;

		pat = this.patientinfoservice.updateDetails(patientinfo, patientId);

		if (pat != null) {
			System.out.println("Update successfully");
			return ResponseEntity.accepted().body(patientinfo);
		} else {
			throw new PatientServiceException("Patient Id is not valid  "+patientId);
		}

	}

	// to fetch patient of a particular id
	@GetMapping("/patient")
	public ResponseEntity<PatientInfo> showAvailability(@RequestParam(value = "patientId") String patientId) throws PatientServiceException {
		PatientInfo patientInfo = (PatientInfo) patientinfoservice.getpatientinfo(patientId);
		
		return ResponseEntity.ok().body(patientInfo);
	}

	// to fetch all patient present in table, this is only for admin
	@GetMapping("/patients")
	public ResponseEntity<List<PatientInfo>> showAllAvailability() throws PatientServiceException {
		List<PatientInfo> list = patientinfoservice.showAllAvailability();
		if (list.size() <= 0) {
			throw new PatientServiceException("Patient information does not exist ");
		}
		return ResponseEntity.ok().body(list);
	}

}
