package com.accio.springBoot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


@RestController
    public class MainController {
        private final List<Patient> patinets=new ArrayList<>();
        long id;

        public MainController(){
            patinets.add(new Patient(1,"jonh",15));
            patinets.add(new Patient(2,"siya",25));
            patinets.add(new Patient(3,"gill",22));
        }
        @GetMapping("/patient")
        public List<Patient> getPatinets(){
            return patinets;
        }

        // Post
        @PostMapping("/addPatient")
        public List<Patient>addPatient(@RequestBody PatientInput patientInput){
            patinets.add(new Patient(id+1, patientInput.name,patientInput.age));
            id++;
            return patinets;
        }
        //update
        @PutMapping("/updatepatient/{id}")
        public List<Patient> updatePatient(@PathVariable long id,@RequestBody PatientInput input){
            Patient patient=patinets.get((int) id-1);
            patient.setName(input.getName());
            return patinets;
        }

        //delete
//        @DeleteMapping("/deletePatient/{id}")
//        public ResponseEntity<Object> deletePatient(@PathVariable long id){
//           // patinets.remove(id-1);
//            int flag=0;
//            for(Patient p:patinets){
//                if(p.getId()==id){
//                    patinets.remove(p);
//                    flag=1;
//                }
//            }
//            if(flag==0){
//                return  ResponseEntity.status(404).body("Patient Not Found !");
//            }
//            return ResponseEntity.ok(patinets);
//        }
        @GetMapping("/searchPatient")
        public List<Patient> searchPatient(@RequestParam("name") String name){
            List<Patient> finalPatient=new ArrayList<>();

            for(Patient p:patinets){
                if(p.getName().equals(name)){
                    finalPatient.add(p);
                }
            }
            return finalPatient;

        }
        @GetMapping("/browse")
        public List<Patient> getSortBy(@RequestParam String param){
            List<Patient> sortPatient=new ArrayList<>();
            if(param.equals("id")){
                patinets.sort((p1,p2 )->
                      Integer.compare((int)p1.getId(),(int)p2.getId())
                );
            } else if (param.equals("name")) {
                patinets.sort((p1,p2 )->
                        p1.getName().compareTo(p2.getName())
                );
            }else{
                patinets.sort((p1,p2) ->
                        Integer.compare((int)p1.getAge(),(int)p2.getAge())
                );
            }
         return sortPatient;
        }


    }


