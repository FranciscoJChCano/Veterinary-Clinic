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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        mockMvc.perform(delete("/api/patients/{id}", id))
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

        mockMvc.perform(put("/api/patients/1")
                        .contentType("application/json")
                        .content("{\"id\":1,\"name\":\"Buddy\",\"age\":5,\"breed\":\"Golden Retriever\",\"gender\":\"Male\",\"identificationNumber\":\"12345\",\"tutorFirstName\":\"John\",\"tutorLastName\":\"Doe\",\"tutorPhoneNumber\":\"555-1234\"}"))
                .andExpect(status().isOk());

    }

    @Test
    void testGetAllPatient() throws Exception {
        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPatient() throws Exception {
        Long patientId = 1L;
        when(patientServices.getPatient(patientId)).thenReturn(List.of(new Patient(1L,"John Doe",12,"perro","macho","238489","fran","cano","76458743","ok","ok",null)));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patients/patients/{id}", patientId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("John Doe"));

        verify(patientServices, times(1)).getPatient(patientId);
    }
}