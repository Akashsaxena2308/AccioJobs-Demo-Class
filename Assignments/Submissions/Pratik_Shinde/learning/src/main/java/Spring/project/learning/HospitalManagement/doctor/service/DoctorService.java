package Spring.project.learning.HospitalManagement.doctor.service;

import Spring.project.learning.HospitalManagement.doctor.Entity.Doctor;
import Spring.project.learning.HospitalManagement.doctor.Model.DoctorInput;
import Spring.project.learning.HospitalManagement.doctor.Repository.DoctorRepository;
import Spring.project.learning.HospitalManagement.patient.Entity.Patient;
import Spring.project.learning.HospitalManagement.patient.Respository.HospitalPatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository){
        this.repository = repository;
    }

    public List<Doctor> getAllDoctor(){
        return repository.findAll();
    }

    public List<Doctor> addDoctor(DoctorInput doctorInput){
        repository.add(doctorInput);
        return repository.findAll();
    }

    public DoctorInput assign(Long doctor_id, Long patient_id){
        repository.assign(doctor_id, patient_id);
        List<Patient> find = repository.findPatient(doctor_id);
        DoctorInput di = new DoctorInput();
        di.setPatients(find);
        return di;
    }
}
