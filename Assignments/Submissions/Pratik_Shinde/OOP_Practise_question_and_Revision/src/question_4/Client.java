package question_4;

//4. Write a Java program to create a class called "Circle" with a radius attribute. You can access and modify this attribute. Calculate the area and circumference of the circle.
public class Client {
    public static void main(String args[]){
        Circle c1 = new Circle(5);
        System.out.println("Area : "+c1.area());
    }
}
