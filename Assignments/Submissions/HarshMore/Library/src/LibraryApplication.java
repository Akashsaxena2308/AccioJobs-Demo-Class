public class LibraryApplication {

    public static void main(String[] args) {

        Book book = new Book(1, "Atomic Habits", "James Clear");

        Magazine magazine = new Magazine(2, "Tech Today", 25);

        ReferenceBook referenceBook =
                new ReferenceBook(3, "Java Complete Reference", "Programming");

        // Display all three
        book.displayDetails();
        magazine.displayDetails();
        referenceBook.displayDetails();

        // Borrow book
        borrowItem(book);
        borrowItem(magazine);

        // borrowing book again
        borrowItem(book);

        // Return book
        book.returnItem();

        // returning book again
        book.returnItem();
    }

    public static void borrowItem(Borrowable item) {
        item.borrow();
    }
}