package question_6;

public class Employee {
    private String name;
    private String job_title;
    private long salary;

    public Employee(String name, String job_title, long salary) {
        this.name = name;
        this.job_title = job_title;
        this.salary = salary;
    }

    public long calculateSalary(int increament){
        return  (long)((this.salary) * (increament/100));
    }

    public void update_Salary(int increment){
        this.salary += calculateSalary(increment);
    }

    public void detail(){
        System.out.println("-------------------------------------------------");
        System.out.println("Name : "+name+"\njob title : "+job_title+"\nsalary : "+salary);
        System.out.println("-------------------------------------------------");
    }
}
