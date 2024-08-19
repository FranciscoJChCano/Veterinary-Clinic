package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AppointmentServicesTest {

    @InjectMocks
    private AppointmentServices appointmentServices;

    @Mock
    private IAppointmentRepository iAppointmentRepository;

    private Appointment appointment;

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

    @Test
    void test_Create_Appointment_Id() {
        Appointment appointment = new Appointment();
        when(iAppointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentServices.createAppointment(appointment);

        assertNotNull(result);
        verify(iAppointmentRepository, times(1)).save(any(Appointment.class));
    }

    @Test
    void test_Create_Appointment_reason() {
        Appointment appointment = new Appointment();
        appointment.setReason("General check");
        when(iAppointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentServices.createAppointment(appointment);

        assertNotNull(result);
        verify(iAppointmentRepository).save(any(Appointment.class));
    }

    @Test
    void test_Create_Appointment_status() {
        Appointment appointment = new Appointment();
        appointment.setStatus(false);
        when(iAppointmentRepository.save(any(Appointment.class))).thenReturn(appointment);

        Appointment result = appointmentServices.createAppointment(appointment);

        assertNotNull(result);
        verify(iAppointmentRepository).save(any(Appointment.class));
    }

    @Test
    void testGetAppointmentsByPatientId() {
        // Arrange
        Long patientId = 1L;
        Appointment appointment1 = new Appointment(1L,null,"null",null,true,null);
        Appointment appointment2 = new Appointment(2L, null,"null",null,true,null);
        List<Appointment> expectedAppointments = Arrays.asList(appointment1, appointment2);

        when(iAppointmentRepository.findByPatientId(patientId)).thenReturn(expectedAppointments);

        // Act
        List<Appointment> actualAppointments = appointmentServices.getAppointmentsByPatientId(patientId);

        // Assert
        assertEquals(expectedAppointments, actualAppointments);
    }

}

