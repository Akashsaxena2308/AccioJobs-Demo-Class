package com.accio.springProject.DependencyInjection;

public class DIMain {
    public static void main(String[] args){
        PatientRepository repository = new PatientRepository();
        PatientService service = new PatientService(repository);
        System.out.println(service.getPatientName(1)); // Asha

        repository.rename(1, "Meera");
        System.out.println(service.getPatientName(1)); // Meera

        PatientService separate = new PatientService(new PatientRepository());
        System.out.println(separate.getPatientName(1)); // Asha: different storage
    }
}
