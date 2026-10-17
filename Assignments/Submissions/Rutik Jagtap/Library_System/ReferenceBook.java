public class ReferenceBook extends LibraryItem {
    private String subject;

    public ReferenceBook(int item_ID, String item_Name, String subject) {
        super(item_ID, item_Name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Reference Book ---");
        System.out.println("Item ID: " + getItem_ID());
        System.out.println("Title: " + getItem_Name());
        System.out.println("Subject: " + subject);
        System.out.println("Note: Reference books can only be read inside the library.");
    }
}
