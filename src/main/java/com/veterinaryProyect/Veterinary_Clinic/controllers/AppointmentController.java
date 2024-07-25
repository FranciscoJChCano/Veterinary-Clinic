package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AppointmentController {

    @Autowired
    AppointmentServices appointmentServices;

    @GetMapping(path = "/appointment")
    public List<Appointment> getAllAppointment() {
        return appointmentServices.getAllAppointment();
    }

    @GetMapping(path = "/appointment/{id}")
    public Appointment getAppointmentById(@PathVariable("id") Long id) {
        return appointmentServices.getById(id);
    }

    @DeleteMapping(path = "/appointment/{id}")
    public void deleteAppointmentById(@PathVariable("id") Long id) {
        appointmentServices.deleteAppointment(id);

    }

}
