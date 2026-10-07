package Library;

class ReferenceBook extends LibraryItem {
    private String subject;

    public ReferenceBook(int itemId, String title, String subject) {
        super(itemId, title);
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        // id + title + subject
        System.out.println("Item ID : " + super.getItemId() + "\nReference Book Title : " + super.getTitle() + "\nReference Book Subject : " + subject);
    }
}