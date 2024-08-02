package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping(path = "/patients")
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/patients/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
    }

    @DeleteMapping(path = "/patients/{id}")
    public void deletePatientById(@PathVariable("id") Long id) {patientServices.deletePatient(id); }

    @PostMapping(path = "/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientServices.createPatient(patient);
    }

    @PutMapping(path = "/patients/{id}")
    public void updateImage(@RequestBody Patient patient, @PathVariable long id) {
        patientServices.updatePatient(patient, id);
    }
}
