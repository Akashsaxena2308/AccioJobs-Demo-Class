package question_6;

//6. Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.
public class Client {
    public static void main(String args[]){
        Employee e1 = new Employee("Pratik Shinde", "Developer", 10000000);
        e1.update_Salary(50);
        e1.detail();

        Employee e2 = new Employee("Luff", "Pirate", 10000000);
        e2.update_Salary(10);
        e2.detail();
    }
}
