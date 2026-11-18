package com.accio.springProject.Hospital.Service;

import com.accio.springProject.Hospital.Entity.Patient;
import com.accio.springProject.Hospital.Repository.HospitalPatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HospitalPatientServiceTest {

    @Mock
    private HospitalPatientRepository repository;

    private HospitalPatientService service;

    @BeforeEach
    void setup(){
        this.service = new HospitalPatientService(repository);
    }

    @Test
    void deleteMissingPatient(){
        when(repository.delete(1L)).thenReturn(true);
        assertTrue(service.deletePatient(1L));
        verify(repository).delete(1L);
    }

    @Test
    void testGetSortedByName(){
        when(repository.findAll()).thenReturn(
                new ArrayList<>(List.of(
                        new Patient(1, "Luna", 23),
                        new Patient(2, "Jane", 26),
                        new Patient(3, "James", 55),
                        new Patient(4, "James", 69)
                ))
        );
        List<Patient> result = service.getSortedBy("name");
        assertEquals(result.get(0).getId(), 3);
        assertEquals(result.get(1).getId(), 4);
        assertEquals(result.get(2).getId(), 2);
        assertEquals(result.get(3).getId(), 1);

    }
}
