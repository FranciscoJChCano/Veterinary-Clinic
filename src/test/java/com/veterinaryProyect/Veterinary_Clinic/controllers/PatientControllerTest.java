package com.veterinaryProyect.Veterinary_Clinic.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.veterinaryProyect.Veterinary_Clinic.models.Patient;
import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientServices patientServices;

    @InjectMocks
    private PatientController patientController;

    private Patient patient;

    @Test
    public void deletePatientById_ShouldReturnOk() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/patient/{id}", id))
                .andExpect(status().isOk());

        verify(patientServices).deletePatient(id);
    }


    @BeforeEach
    void setUp() {
        patient = new Patient();
        patient.setId(1L);
        patient.setName("Blacky");
        patient.setAge(3);
        patient.setBreed("Poodle");
        patient.setGender("Male");
    }

    @Test
    void test_Create_Patient_Id() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Name() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals("Blacky", result.getName());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Age() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals(3, result.getAge());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Breed() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals("Poodle", result.getBreed());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void test_Create_Patient_Gender() {

        when(patientServices.createPatient(any(Patient.class))).thenReturn(patient);

        Patient result = patientController.createPatient(patient);

        assertNotNull(result);
        assertEquals("Male", result.getGender());
        verify(patientServices, times(1)).createPatient(any(Patient.class));
    }

    @Test
    void updatePatient() throws Exception {
        Patient updatedPatient = new Patient();
        updatedPatient.setId(1L);
        updatedPatient.setName("Buddy");
        updatedPatient.setAge(5);
        updatedPatient.setBreed("Golden Retriever");
        updatedPatient.setGender("Male");
        updatedPatient.setIdentificationNumber("12345");
        updatedPatient.setTutorFirstName("John");
        updatedPatient.setTutorLastName("Doe");
        updatedPatient.setTutorPhoneNumber("555-1234");

        doNothing().when(patientServices).updatePatient(updatedPatient,1L);

        mockMvc.perform(put("/patient/1")
                        .contentType("application/json")
                        .content("{\"id\":1,\"name\":\"Buddy\",\"age\":5,\"breed\":\"Golden Retriever\",\"gender\":\"Male\",\"identificationNumber\":\"12345\",\"tutorFirstName\":\"John\",\"tutorLastName\":\"Doe\",\"tutorPhoneNumber\":\"555-1234\"}"))
                .andExpect(status().isOk());

    }

    @Test
    void testGetAllPatient() throws Exception {
        when(patientServices.getAllPatient()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/patient").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(patientServices, times(1)).getAllPatient();
    }

    @Test
    void testGetPatientById() throws Exception {
        Patient patient = new Patient();
        patient.setId(1L);


        when(patientServices.getById(1L)).thenReturn(patient);

        mockMvc.perform(get("/patient/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

        verify(patientServices, times(1)).getById(1L);
    }
}