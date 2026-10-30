package Hospital.Model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class PatientInput {
    @NotNull
    private String name;

    @Min(value=0,message="Age Should be atleast 0")
    @Max(value=120, message="Age cannot be more than 120")
    private  int age;

//    public PatientInput() {
//    }
    public PatientInput(String name,int age){
        this.name=name;
        this.age=age;
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
    public void setAge(int age){
        this.age=age;
    }
}
