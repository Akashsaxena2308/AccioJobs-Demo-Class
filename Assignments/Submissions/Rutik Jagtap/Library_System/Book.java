public class Book extends LibraryItem implements Borrowable {
    private String author;
    private boolean isBorrowed;

    public Book(int item_ID, String item_Name, String author) {
        super(item_ID, item_Name);
        this.author = author;
        this.isBorrowed = false;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    @Override
    public void borrowItem() {
        if (isBorrowed) {
            System.out.println("Cannot borrow: '" + getItem_Name() + "' is already borrowed.");
        } else {
            isBorrowed = true;
            System.out.println("Successfully borrowed: '" + getItem_Name() + "' by " + author);
        }
    }

    @Override
    public void returnItem() {
        if (!isBorrowed) {
            System.out.println("Cannot return: '" + getItem_Name() + "' was not borrowed.");
        } else {
            isBorrowed = false;
            System.out.println("Successfully returned: '" + getItem_Name() + "' by " + author);
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Book ---");
        System.out.println("Item ID: " + getItem_ID());
        System.out.println("Title: " + getItem_Name());
        System.out.println("Author: " + author);
        System.out.println("Borrowed: " + isBorrowed);
    }
}
