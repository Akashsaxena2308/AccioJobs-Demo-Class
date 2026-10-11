package question_3;
//3. Write a Java program to create a class called "Rectangle" with width and height attributes. Calculate the area and perimeter of the rectangle.
public class Client {
    public static void main(String args[]){
        Rectangle rec = new Rectangle(5,6);
        System.out.println("Area : "+rec.area());
        System.out.println("Perimeter : "+rec.perimeter());
    }
}
