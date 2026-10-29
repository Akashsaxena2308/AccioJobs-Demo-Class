package Spring.project.learning.HospitalManagement.patient.Service;

import Spring.project.learning.HospitalManagement.patient.Entity.Patient;
import Spring.project.learning.HospitalManagement.patient.Model.PatientInput;
import Spring.project.learning.HospitalManagement.patient.Respository.HospitalPatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalPatientService {

    private final HospitalPatientRepository repository;

    public HospitalPatientService(HospitalPatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> getPatients(){
        return repository.findAll();
    }

    public List<Patient> addPatient(PatientInput input){
        repository.add(input);
        return repository.findAll();
    }

    public List<Patient> updatePatient(long id, PatientInput input){
        repository.updateName(id, input);
        return  repository.findAll();
    }

    public boolean deletePatient(long id){
        return repository.delete(id);
    }

    public List<Patient> searchByName(String name){
        List<Patient> finalPatient = new ArrayList<>();

        for( Patient p : repository.findAll()){
            if(p.getName().equals(name)){
                finalPatient.add(p);
            }
        }

        return  finalPatient;
    }

    public List<Patient> getSortedBy(String param){
        List<Patient> patients = repository.findAll();

        if(param.equals("id")){
            patients.sort(
                    (p1, p2) ->
                            Long.compare(p1.getId(), p2.getId())
            );
        }
        else if(param.equals("name")){
            patients.sort(
                    (p1, p2) ->
                            p1.getName().compareTo(p2.getName())
            );
        }
        else {
            patients.sort(
                    (p1, p2) ->
                            Integer.compare((int)p1.getAge(), (int)p2.getAge())
            );
        }

        return patients;
    }
}