package LibraryApplication;

public class Book extends BorrowItem{
    private String author;

    public Book(int itemId, String title, int quantity, String author){
        super(itemId, title, quantity);
        this.author = author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book");
        displayCommonDetails();
        System.out.println("Author : "+author);
    }
}
