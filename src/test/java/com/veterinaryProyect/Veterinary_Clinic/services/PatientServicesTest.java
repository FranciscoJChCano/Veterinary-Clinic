package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @Test
    void testGetAllPatient() {
        ArrayList<Patient> PatientList = new ArrayList<>();
        Patient patient = new Patient();
        PatientList.add(patient);

        when(iPatientRepository.findAll()).thenReturn(PatientList);

        List<Patient> result = patientService.getAllPatient();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(iPatientRepository, times(1)).findAll();
    }

    @Test
    void testGetPatientById() {
        Patient patient = new Patient();
        when(iPatientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Patient result = patientService.getById(1L);

        assertNotNull(result);
        verify(iPatientRepository, times(1)).findById(1L);
    }
}