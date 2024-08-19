package com.veterinaryProyect.Veterinary_Clinic.repositories;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import org.springframework.data.repository.CrudRepository;


public interface IPatientRepository extends CrudRepository<Patient, Long> {
}
