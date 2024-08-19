package com.veterinaryProyect.Veterinary_Clinic.services;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.springframework.beans.BeanUtils;
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

    public List<Appointment> getAppointmentsByPatientId(Long patient_Id) {
        return iAppointmentRepository.findByPatientId(patient_Id);
    }
    public List<Appointment> getAppointment(Long id) {
        return iAppointmentRepository.findByPatientId(id);
    }

    public void deleteAppointment(long id) {iAppointmentRepository.deleteById(id); }

    public Appointment createAppointment(Appointment appointment) {
        return iAppointmentRepository.save(appointment);
    }

    public void updateAppointment(Appointment appointment, Long id) {
        appointment.setId(id);
        iAppointmentRepository.save(appointment);
    }
}