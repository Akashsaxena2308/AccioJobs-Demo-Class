package Hospital.Entity;

public class PatientTest {
    public static void main(String[] args){
        Patient p1=new Patient(1,"jonh",20);
        Patient p2=new Patient(2,"Jane",22);

        System.out.println(p1.getName());
        p1.setName("Amit");
        System.out.println(p1.getName());
        System.out.println(p1.getId());
        System.out.println(p1.getAge());

        System.out.println(p2.getName());
        System.out.println(p2.getId());
        System.out.println(p2.getAge());
    }
}
