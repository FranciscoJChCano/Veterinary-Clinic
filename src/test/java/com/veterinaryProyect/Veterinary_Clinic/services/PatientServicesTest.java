package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
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
    @Test
    void updatePatient() {
        long id = 1L;
        Patient patient = new Patient();
        patient.setName("Buddy");
        patient.setAge(5);
        patient.setBreed("Golden Retriever");
        patient.setGender("Male");
        patient.setIdentificationNumber("12345");
        patient.setTutorFirstName("John");
        patient.setTutorLastName("Doe");
        patient.setTutorPhoneNumber("555-1234");

        patientService.updatePatient(patient, id);

        verify(iPatientRepository).save(patient);
        assertEquals(id, patient.getId());
    }


}