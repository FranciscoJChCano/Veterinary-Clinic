package com.veterinaryProyect.Veterinary_Clinic.controllers;

import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PatientController {

    @Autowired
    PatientServices patientServices;
}
