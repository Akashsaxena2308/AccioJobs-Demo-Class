package Library;

class Magazine extends BorrowableItem {
    private int issueNumber;

    public Magazine(int itemId, String title, int issueNumber) {
        super(itemId, title);
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayDetails() {
        // id + title + issue number
        System.out.println("Item ID : " + super.getItemId() + "\nMagazine Title : " + super.getTitle() + "\nMagazine Issue Number : " + issueNumber);

    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
}
