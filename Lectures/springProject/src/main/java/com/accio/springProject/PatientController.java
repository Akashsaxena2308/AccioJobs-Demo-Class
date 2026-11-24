package com.accio.springProject;

import com.accio.springProject.Hospital.Model.PatientInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class PatientController {
    private final List<Patients> list;
    int id;

    PatientController(){
        list = new ArrayList<>();
        list.add(new Patients(1, "aratik"));
        list.add(new Patients(2, "bohit"));
        list.add(new Patients(3, "cohit"));
        list.add(new Patients(4, "dohit"));
        list.add(new Patients(5, "erohit"));
        list.add(new Patients(6, "froten"));
        list.add(new Patients(7, "goti"));
        list.add(new Patients(8, "hratik"));
        list.add(new Patients(9, "iratik"));
        list.add(new Patients(10, "jratik"));
        id = 11;
    }

    @PostMapping("/addPatient")
    public List<Patients> add_patient(@RequestBody PatientInput patientinput){
        list.add(new Patients(id+1, patientinput.getName()));
        id++;
        return list;
    }

    @GetMapping("/allPatient")
    public List<Patients> getAllPatients(){
        return list;
    }

    @PutMapping("/update/{id}")
    public Patients updatePatients(@PathVariable int id, @RequestBody PatientInput patientInput){
        Patients p = list.get(id-1);
        p.setName(patientInput.getName());
        return p;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatients(@PathVariable int id){
        boolean flag = true;
        for (Patients p: list){
            if (p.getId() == id){
                list.remove(p);
                flag = false;
            }
        }

        if (flag){
            return ResponseEntity.status(404).body("Not found");
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public Patients getPatients(@PathVariable int id){
        Patients p1 = list.get(id);
        return p1;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Patients>> getPatientByName(@RequestParam String name){
        List<Patients> list1 = new ArrayList<>();
        for (Patients p: list){
            if (p.getName().equals(name)){
                list1.add(p);
            }
        }

        return ResponseEntity.ok(list1);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Patients>> sortById(@RequestParam String param){
        if (param.equals("id")){
//            Collections.sort(list, (a, b) -> a.getId() -b.getId());
//            list.sort();
        } else if (param.equals("name")) {
            Collections.sort(list, (a, b) -> a.getName().charAt(0) -b.getName().charAt(0));
        }

        return ResponseEntity.ok(list);
    }
}
