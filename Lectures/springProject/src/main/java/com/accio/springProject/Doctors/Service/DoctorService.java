package com.accio.springProject.Doctors.Service;

import com.accio.springProject.Doctors.Model.Doctor;
import com.accio.springProject.Doctors.Repository.DoctorRepository;
import com.accio.springProject.Hospital.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository){ // Constructor Injection
        this.repository = repository;
    }

    public Doctor assign(long doctorId, long patientId){
        Doctor doctor = validateDoctor(doctorId); // ensures that my doctor is valid
        boolean result = repository.assignPatients(doctorId, patientId); // false -->  patientId invalid
        if(!result){
            throw new RuntimeException(); // Invalid Patient
        }
        doctor.setPatientList(repository.findPatientsByDoctorId(doctorId)); // Doctor details and List of its patients
        return doctor;
    }

    public List<Patient> getPatients(long doctorId){
        validateDoctor(doctorId);
        return repository.findPatientsByDoctorId(doctorId);
    }


    private Doctor validateDoctor(long doctorId){
        Doctor doctor = repository.findById(doctorId);
        if(doctor == null){
            throw new RuntimeException(); // Invalid Doctor
        }
        else return doctor;
    }
}
