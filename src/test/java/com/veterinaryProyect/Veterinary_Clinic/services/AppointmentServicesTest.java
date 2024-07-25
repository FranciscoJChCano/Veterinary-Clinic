package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.mockito.Mockito.verify;

import com.veterinaryProyect.Veterinary_Clinic.repositories.IAppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
}

