package LibraryApplication;

public abstract class BorrowItem extends LibraryItem implements Borrow {
    int borrowedCount;
    BorrowItem(int itemId, String title, int quantity) {
        super(itemId, title, quantity);
    }

    @Override
    public void borrowedItem() {
        if (getQuantity() <= 0) {
            System.out.println("Sorry there are no copies available");
            return;
        }
        decreaseQuantity();
        borrowedCount++;
        System.out.println("you borrowed item successfully");
        System.out.println("remaining copies : " + getQuantity());
        System.out.println("borrowed copies : " + borrowedCount);
    }

    @Override
    public void returnItem() {
        if (borrowedCount <= 0) {
            System.out.println("you cannot return copy");
            return;
        }
        borrowedCount--;
        increaseQuantity();
        System.out.println("you returned item successfully");
        System.out.println("remaining copies : "+ getQuantity());
        System.out.println("borrowed copies : " + borrowedCount);
    }

}
