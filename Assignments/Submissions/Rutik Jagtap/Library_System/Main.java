public class Main {

    // Polymorphic method: accepts any LibraryItem and displays its details
    public static void displayItem(LibraryItem item) {
        item.displayDetails();
        System.out.println();
    }

    // Method that only accepts Borrowable items — ReferenceBook cannot be passed here
    public static void borrowAndReturn(Borrowable item) {
        System.out.println("Attempting to borrow...");
        item.borrowItem();

        System.out.println("Attempting to borrow again (should fail)...");
        item.borrowItem();

        System.out.println("Attempting to return...");
        item.returnItem();

        System.out.println("Attempting to return again (should fail)...");
        item.returnItem();
        System.out.println();
    }

    public static void main(String[] args) {
        // 1. Create items of each type
        Book book = new Book(1, "Effective Java", "Rutik");
        Magazine magazine = new Magazine(2, "Java Magazine", 42);
        ReferenceBook referenceBook = new ReferenceBook(3, "Java Encyclopedia", "Computer Science");

        // 2. Display all items using polymorphism
        System.out.println("========== DISPLAYING ALL ITEMS ==========");
        displayItem(book);
        displayItem(magazine);
        displayItem(referenceBook);

        // 3-5. Borrow and return operations on borrowable items
        System.out.println("========== BORROWING OPERATIONS ==========");
        borrowAndReturn(book);
        borrowAndReturn(magazine);

        // 6. ReferenceBook cannot be passed to borrowAndReturn()
        // The following line would cause a COMPILE-TIME ERROR:
        // borrowAndReturn(referenceBook);  // ❌ Compile error: ReferenceBook is not Borrowable
        System.out.println("ReferenceBook cannot be borrowed.");
        System.out.println("The method borrowAndReturn() only accepts Borrowable items.");
        System.out.println("Since ReferenceBook does NOT implement Borrowable,");
        System.out.println("the compiler prevents passing it to borrowAndReturn().");
        System.out.println();

        // Demonstrate the reference book's display
        System.out.println("========== REFERENCE BOOK DETAILS ==========");
        displayItem(referenceBook);
    }
}