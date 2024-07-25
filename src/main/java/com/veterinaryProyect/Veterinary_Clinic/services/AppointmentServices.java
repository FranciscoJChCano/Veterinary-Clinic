package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServices {

    @Autowired
    IAppointmentRepository iAppointmentRepository;


    public List<Appointment> getAllAppointment() {
        return (List<Appointment>) iAppointmentRepository.findAll();
    }

    public Appointment getById(Long id) {
        Appointment appointment;
        appointment = iAppointmentRepository.findById(id).orElseThrow();
        return appointment;

    }

    public void deleteAppointment(long id) {iAppointmentRepository.deleteById(id); }


}
