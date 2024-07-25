package com.veterinaryProyect.Veterinary_Clinic.controllers;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.veterinaryProyect.Veterinary_Clinic.services.AppointmentServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = AppointmentController.class)
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppointmentServices appointmentServices;

    @Test
    public void deleteAppointmentById_ShouldReturnOk() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/appointment/{id}", id)).andExpect(status().isOk());

        verify(appointmentServices).deleteAppointment(id);
    }
}