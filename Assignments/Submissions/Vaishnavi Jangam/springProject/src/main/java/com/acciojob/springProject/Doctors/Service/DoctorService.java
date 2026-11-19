package com.acciojob.springProject.Doctors.Service;

import com.acciojob.springProject.Doctors.Model.Doctor;
import com.acciojob.springProject.Doctors.Model.DoctorWorkload;
import com.acciojob.springProject.Doctors.Model.RebalanceResult;
import com.acciojob.springProject.Doctors.Repository.DoctorRepository;
import com.acciojob.springProject.HospitalManagement.Entity.Patient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository repository;
    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor assign(long doctorId, long patientId){
        Doctor doctor = validateDoctor(doctorId);

        boolean result = repository.assignPatients(doctorId, patientId);

        if(!result){
            throw new RuntimeException("Patient" + patientId + " not found!!!!");
        }
        doctor.setPatientList(repository.findPatientsByDoctorId(doctorId));
        return doctor;
    }

    public List<Patient> getPatients(long doctorId ){
        return repository.findPatientsByDoctorId(doctorId);
    }


    private Doctor validateDoctor(long doctorId){
        Doctor doctor = repository.findById(doctorId);
        if(doctor == null){
            throw new RuntimeException("Doctor " + doctorId + " not found!!!!");
        }
        else return doctor;
    }

    public List<DoctorWorkload> getWorkload(){
        List<DoctorWorkload> result = new ArrayList<>();
        for(Doctor doctor : repository.findAll()){
            int count = repository.findPatientsByDoctorId(doctor.getId()).size();
            result.add(new DoctorWorkload(doctor.getId(), doctor.getName(), count));
        }
        result.sort(Comparator.comparingInt(DoctorWorkload::getPatientCount)
                .reversed()
                .thenComparing(DoctorWorkload::getDoctorId));
        return result;
    }

    public RebalanceResult rebalance(){
        List<DoctorWorkload> workloads = getWorkload();
        if(workloads.size() < 2){
            return new RebalanceResult(false, "Atleast 2 doctors are needed", null, null, null);
        }
        DoctorWorkload busiest = workloads.get(0);
        DoctorWorkload leastBusy = workloads.get(0);
        for(DoctorWorkload current :  workloads){
            if(current.getPatientCount() < leastBusy.getPatientCount()
            || current.getPatientCount() == leastBusy.getPatientCount()
            && current.getDoctorId() < leastBusy.getDoctorId()){
                leastBusy = current;
            }
        }
        if(busiest.getPatientCount() - leastBusy.getPatientCount() <= 1){
            return new RebalanceResult(false, "No balancing needed",
                    null, null, null);
        }
        List<Patient> patients = repository.findPatientsByDoctorId(busiest.getDoctorId());
        if(patients.isEmpty()){
            return new RebalanceResult(false, "Workload changed; try again", null, null, null);
        }
        long patientId = patients.get(0).getId();
        boolean updated = repository.assignPatients(leastBusy.getDoctorId(), patientId);
        if(!updated){
            return new RebalanceResult(false, "Patient no longer exist; tru again", null, null, null);
        }
        return new RebalanceResult(true, "One patient reassigned", patientId, busiest.getDoctorId(), leastBusy.getDoctorId());
    }
}
