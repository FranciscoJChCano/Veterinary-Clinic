package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;

    @GetMapping(path = "/patient")
    public List<Patient> getAllPatient() {
        return patientServices.getAllPatient();
    }

    @GetMapping(path = "/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id) {
        return patientServices.getById(id);
    }
}
