package Spring.project.learning.HospitalManagement.doctor.Entity;

public class Doctor {
    private final Long id;
    private final String name;

    public Doctor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
