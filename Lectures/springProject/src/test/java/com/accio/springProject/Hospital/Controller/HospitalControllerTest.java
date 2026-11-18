package com.accio.springProject.Hospital.Controller;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Model.PatientInput;
import com.accio.springProject.Hospital.Service.HospitalPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalController.class)
public class HospitalControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private HospitalPatientService service;

    @Test
    void getPatientsTest() throws Exception {

        when(service.getPatients())
                .thenReturn(List.of(
                        new Patient(5, "James", 25),
                        new Patient(2, "Luna", 28)
                ));

        mvc.perform(get("/hospital/patients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(5))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[0].name").value("James"));
    }


    @Test
    void addPatientsTest() throws Exception {

        when(service.addPatient(any(PatientInput.class))).thenReturn(
                List.of(
                        new Patient(5, "James", 25)
                )
        );

        mvc.perform(post("/hospital/addPatient")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"James\", \"age\":25}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("James"));
    }

    @Test
    void negativeAgeIsNotAllowed() throws Exception {
        mvc.perform(post("/hospital/addPatient")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"James\", \"age\":-1}"))
                .andExpect(status().isBadRequest());
    }
}
