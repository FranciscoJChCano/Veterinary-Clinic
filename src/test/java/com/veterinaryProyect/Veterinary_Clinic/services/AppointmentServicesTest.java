package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.veterinaryProyect.Veterinary_Clinic.models.Appointment;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
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
    void testGetAllAppointment() {
        ArrayList<Appointment> AppointmentList = new ArrayList<>();
        Appointment appointment = new Appointment();
        AppointmentList.add(appointment);

        when(iAppointmentRepository.findAll()).thenReturn(AppointmentList);

        List<Appointment> result = appointmentServices.getAllAppointment();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iAppointmentRepository, times(1)).findAll();
    }

    @Test
    void testGetAppointmentById() {
        Appointment appointment = new Appointment();
        when(iAppointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        Appointment result = appointmentServices.getById(1L);

        assertNotNull(result);
        verify(iAppointmentRepository, times(1)).findById(1L);
    }

}

