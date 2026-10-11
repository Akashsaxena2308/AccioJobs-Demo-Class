package question_2;

//2. Write a Java program to create a class called "Dog" with a name and breed attribute. Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.
public class Client {
    public static void main(String args[]){
        Dog d1 = new Dog("chihuahua", "tiny");
        System.out.println(d1.getName()+" : "+d1.getBreed());
        d1.setName("shih Tzu");
        System.out.println(d1.getName()+" : "+d1.getBreed());
    }
}
