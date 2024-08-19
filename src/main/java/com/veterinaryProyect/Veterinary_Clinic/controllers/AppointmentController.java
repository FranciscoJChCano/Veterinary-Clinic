package com.veterinaryProyect.Veterinary_Clinic.controllers;


import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentServices appointmentServices;

    @GetMapping("/{patient_Id}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patient_Id) {
        return appointmentServices.getAppointmentsByPatientId(patient_Id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAppointmentById(@PathVariable("id") Long id) {
        appointmentServices.deleteAppointment(id);
    }

    @PostMapping(path = "")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentServices.createAppointment(appointment);
    }

    @PutMapping(path = "/{id}")
    public void updateImage(@RequestBody Appointment appointment, @PathVariable Long id) {
        appointmentServices.updateAppointment(appointment, id);
    }
}