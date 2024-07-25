package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServices {

    @Autowired
    IPatientRepository iPatientRepository;

    public List<Patient> getAllPatient() {
        return (List<Patient>) iPatientRepository.findAll();
    }

    public Patient getById(Long id) {
        Patient patient;
        patient = iPatientRepository.findById(id).orElseThrow();
        return patient;

    }

    public void deletePatient(long id) {iPatientRepository.deleteById(id); }
}
