package com.veterinaryProyect.Veterinary_Clinic.repositories;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends CrudRepository<Patient, Long> {
}
