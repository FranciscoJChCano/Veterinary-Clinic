package com.veterinaryProyect.Veterinary_Clinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.repositories.IPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
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

    @Test
    void test_Create_Patient_Id() {
        Patient patient = new Patient();
        when(iPatientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.createPatient(patient);

        assertNotNull(result);
        verify(iPatientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Name() {
        Patient patient = new Patient();
        patient.setName("Blacky");
        when(iPatientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.createPatient(patient);

        assertNotNull(result);
        verify(iPatientRepository).save(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Breed() {
        Patient patient = new Patient();
        patient.setBreed("Caniche");
        when(iPatientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.createPatient(patient);

        assertNotNull(result);
        verify(iPatientRepository).save(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Age() {
        Patient patient = new Patient();
        patient.setAge(3);
        when(iPatientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.createPatient(patient);

        assertNotNull(result);
        verify(iPatientRepository).save(any(Patient.class));
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