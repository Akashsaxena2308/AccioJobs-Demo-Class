package LibraryApplication;

public class LibraryApplication {
    public static void main(String[] args) {
        Book book = new Book(101, "Java Programming", 3,"James Gosling");

        Magazine magazine = new Magazine(102, "Tech Today", 2, 25);

        referenceBook referenceBook = new referenceBook(103, "Physics Encyclopedia", 5, "Physics");

        //referenceBook.displayDetails();
        //magazine.displayDetails();
        //book.displayDetails();

        magazine.borrowedItem();
        magazine.borrowedItem();
        //when magazine not available
        magazine.borrowedItem();

        magazine.returnItem();
        magazine.borrowedItem();
    }
}
