package Library;

public abstract class BorrowableItem extends LibraryItem implements Borrowable {

    private boolean borrowed;

    public BorrowableItem(int itemId, String title) {
        super(itemId, title);
    }

    public abstract void displayDetails();

    @Override
    public void borrow() {
        if (borrowed) System.out.println("Rejected");
        else borrowed = true;
    }

    @Override
    public void returnItem() {
        // agar borrowed nahi hai toh reject
        // otherwise borrowed = false
        if (!borrowed) System.out.println("Rejected");
        else borrowed = false;
    }

}