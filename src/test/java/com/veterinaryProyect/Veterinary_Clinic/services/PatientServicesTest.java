package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.mockito.Mockito.verify;

import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PatientServicesTest {
    @InjectMocks
    private PatientServices patientService;

    @Mock
    private IPatientRepository iPatientRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void deletePatient_ShouldCallDeleteById() {
        long id = 1L;

        patientService.deletePatient(id);

        verify(iPatientRepository).deleteById(id);
    }


}