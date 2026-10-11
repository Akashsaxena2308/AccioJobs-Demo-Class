package question_5;

//5. Write a Java program to create a class called "Book" with attributes for title, author, and ISBN, and methods to add and remove books from a collection.
public class Client {
    public static void main(String args[]){
        Book b1 = new Book("atomic habit", "James clear");
        Book b2 = new Book("The God of Small Things", "Arundhati Roy");
        Book b3 = new Book("Gitanjali", "Rabindranath Tagore");
        Book b4 = new Book("A Suitable Boy", "Vikram Seth");
        Book b5 = new Book("The White Tiger", "Aravind Adiga");
        Book b6 = new Book("The Inheritance of Loss", "Kiran Desai");
        Book_Collection book_collection = new Book_Collection();
        book_collection.add(b1);
        book_collection.add(b2);
        book_collection.add(b3);
        book_collection.add(b4);
        book_collection.add(b5);
        book_collection.add(b6);
        book_collection.print();
        book_collection.remove(b3);
        System.out.println("----------------------------------------");
        book_collection.print();
    }
}
