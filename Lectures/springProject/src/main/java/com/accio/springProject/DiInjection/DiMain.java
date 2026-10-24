package com.accio.springProject.DiInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiMain {

    public static void main(String[] args){
//        PatientRepository repository =  new PatientRepository(); //1 --> Jane
//        PatientService service = new PatientService(repository);
//
//        System.out.println(service.getPatientName(1)); //John
//
//        repository.rename(1, "Jane");
//
//        System.out.println(service.getPatientName(1)); //Jane
//
//
//        PatientService service1 = new PatientService(new PatientRepository());
//        System.out.println(service1.getPatientName(1));
//        System.out.println(service.getPatientName(1));

            try(var context = new AnnotationConfigApplicationContext("com.accio.springProject.DiInjection")){
                PatientService service = context.getBean(PatientService.class);

                PatientRepository repository = context.getBean(PatientRepository.class);

                System.out.println(service.getPatientName(1));

                repository.rename(1, "Jane");

                System.out.println(service.getPatientName(1));

                PatientService service1 = context.getBean(PatientService.class);

                System.out.println(service1.getPatientName(1));

            }
    }
}



//Class --> Final Hashmap


// Object1   --> Hashmap
// Object2   --> Hashmap


// @Component

// @Service

// @Repository

// @Controller