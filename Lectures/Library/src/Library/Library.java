package Library;

public class Library {

    public static void main(String[] args){
        Book book = new Book("b1", "java basics", "John");
        Magazine magazine = new Magazine("m1", "Science", "123");
        ReferenceBook ref = new ReferenceBook("r1", "World", "Geography");

        book.displayDetails();
        magazine.displayDetails();
        ref.displayDetails();

        System.out.println(book.isBorrowed());

        System.out.println(book.borrow());
        System.out.println(book.borrow());


    }

}
