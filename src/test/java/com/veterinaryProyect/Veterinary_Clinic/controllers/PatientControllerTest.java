package com.veterinaryProyect.Veterinary_Clinic.controllers;



import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.veterinaryProyect.Veterinary_Clinic.services.PatientServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private PatientServices patientServices;

    @Test
    public void deletePatientById_ShouldReturnOk() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/patient/{id}", id))
                .andExpect(status().isOk());

        verify(patientServices).deletePatient(id);
    }
}