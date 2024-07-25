package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServices {

    @Autowired
    IPatientRepository iPatientRepository;
}
