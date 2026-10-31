package com.accio.springProject.Doctors.Service;

import com.accio.springProject.Doctors.Model.Doctor;
import com.accio.springProject.Doctors.Repository.DoctorRepository;
import com.accio.springProject.Hospital.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import com.accio.springProject.Doctors.Model.DoctorWorkload;
import com.accio.springProject.Doctors.Model.RebalanceResult;
import com.accio.springProject.Doctors.Exception.DoctorNotFoundException;
import com.accio.springProject.Doctors.Exception.PatientNotFoundException;

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
            throw new PatientNotFoundException(patientId);
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
            throw new DoctorNotFoundException(doctorId);
        }
        else return doctor;
    }

    public List<DoctorWorkload> getWorkload() {
        List<DoctorWorkload> result = new ArrayList<>();
        for (Doctor doctor : repository.findAll()) {
            int count = repository.findPatientsByDoctorId(doctor.getId()).size();
            result.add(new DoctorWorkload(doctor.getId(), doctor.getName(), count));
        }
        result.sort(Comparator.comparingInt(DoctorWorkload::getPatientCount)
                .reversed()
                .thenComparingLong(DoctorWorkload::getDoctorId));
        return result;
    }

    public RebalanceResult rebalance() {
        List<DoctorWorkload> workloads = getWorkload();
        if (workloads.size() < 2) {
            return new RebalanceResult(false, "At least two doctors are needed",
                    null, null, null);
        }
        DoctorWorkload busiest = workloads.get(0);
        DoctorWorkload leastBusy = workloads.get(0);
        for (DoctorWorkload current : workloads) {
            if (current.getPatientCount() < leastBusy.getPatientCount()
                    || (current.getPatientCount() == leastBusy.getPatientCount()
                    && current.getDoctorId() < leastBusy.getDoctorId())) {
                leastBusy = current;
            }
        }
        if (busiest.getPatientCount() - leastBusy.getPatientCount() <= 1) {
            return new RebalanceResult(false, "No balancing needed",
                    null, null, null);
        }
        List<Patient> patients =
                repository.findPatientsByDoctorId(busiest.getDoctorId());
        if (patients.isEmpty()) {
            return new RebalanceResult(false, "Workload changed; try again",
                    null, null, null);
        }
        long patientId = patients.get(0).getId();
        boolean updated = repository.assignPatients(leastBusy.getDoctorId(), patientId);
        if (!updated) {
            return new RebalanceResult(false, "Patient no longer exists; try again",
                    null, null, null);
        }
        return new RebalanceResult(true, "One patient reassigned",
                patientId, busiest.getDoctorId(), leastBusy.getDoctorId());
    }
}
