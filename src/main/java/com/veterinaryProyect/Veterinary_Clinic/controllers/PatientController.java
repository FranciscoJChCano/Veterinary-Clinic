package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/patients/{id}")
    public List<Patient> getPatient(@PathVariable("id") Long id) {
        return patientServices.getPatient(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePatientById(@PathVariable("id") Long id) {patientServices.deletePatient(id); }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.createPatient(patient);
    }

    @PutMapping(path = "/{id}")
    public void updateImage(@RequestBody Patient patient, @PathVariable long id) {
        patientServices.updatePatient(patient, id);
    }
}
