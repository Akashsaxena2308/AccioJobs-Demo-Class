package Hospital.Entity;

public class Patient {
    private final long id;
    private String name;
    private final int age;

    public Patient(long id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
}
