package com.veterinaryProyect.Veterinary_Clinic.repositories;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends CrudRepository<Appointment, Long> {
}
