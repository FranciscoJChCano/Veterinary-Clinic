package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

public class AppointmentServicesTest {

    @InjectMocks
    private AppointmentServices appointmentServices;

    @Mock
    private IAppointmentRepository iAppointmentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deleteAppointment_ShouldCallDeleteById() {
        long id = 1L;

        appointmentServices.deleteAppointment(id);

        verify(iAppointmentRepository).deleteById(id);
    }

    @Test
    void update_appointment() {
        long appointmentId = 1L;
        Appointment appointment = new Appointment();
        appointment.setDateTime(LocalDateTime.now());
        appointment.setReason("Stomacace");
        appointment.setConsultationType("General");
        appointment.setStatus(true);

        appointmentServices.updateAppointment(appointment, appointmentId);

        verify(iAppointmentRepository).save(appointment);
        assertEquals(appointmentId, appointment.getId());
    }
}

