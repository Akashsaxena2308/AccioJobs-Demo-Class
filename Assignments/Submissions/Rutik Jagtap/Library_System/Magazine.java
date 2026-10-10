public class Magazine extends LibraryItem implements Borrowable {
    private int issueNumber;
    private boolean isBorrowed;

    public Magazine(int item_ID, String item_Name, int issueNumber) {
        super(item_ID, item_Name);
        this.issueNumber = issueNumber;
        this.isBorrowed = false;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    @Override
    public void borrowItem() {
        if (isBorrowed) {
            System.out.println("Cannot borrow: '" + getItem_Name() + "' (Issue #" + issueNumber + ") is already borrowed.");
        } else {
            isBorrowed = true;
            System.out.println("Successfully borrowed: '" + getItem_Name() + "' (Issue #" + issueNumber + ")");
        }
    }

    @Override
    public void returnItem() {
        if (!isBorrowed) {
            System.out.println("Cannot return: '" + getItem_Name() + "' (Issue #" + issueNumber + ") was not borrowed.");
        } else {
            isBorrowed = false;
            System.out.println("Successfully returned: '" + getItem_Name() + "' (Issue #" + issueNumber + ")");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Magazine ---");
        System.out.println("Item ID: " + getItem_ID());
        System.out.println("Title: " + getItem_Name());
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Borrowed: " + isBorrowed);
    }
}
