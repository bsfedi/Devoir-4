package com.fedi.patients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fedi.patients.*;
import com.fedi.patients.entities.Patient;
import com.fedi.patients.service.PatientService;

@RestController 
@RequestMapping("/api")
@CrossOrigin
public class PatientRESTController {
	@Autowired
	PatientService patientService ;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Patient> getAllPatients() {
	return patientService.getAllPatients();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Patient getProduitById(@PathVariable("id") Long id) {
	return patientService.getPatient(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Patient createPatient(@RequestBody Patient patient) {
	return patientService.savePatient(patient);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Patient updatePatient(@RequestBody Patient patient) {
	return patientService.updatePatient(patient);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePatient(@PathVariable("id") Long id)
	{
		patientService.deletePatientById(id);
	}
	@RequestMapping(value="/patsmed/{idMed}",method = RequestMethod.GET)
	public List<Patient> getProduitsByCatId(@PathVariable("idMed") Long idMed) {
	return patientService.findByMedecinIdMed(idMed);
	}


	
}
