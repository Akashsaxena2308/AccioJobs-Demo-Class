package LibraryApplication;

public class referenceBook extends LibraryItem {
    private String subject;

    public referenceBook(int itemId, String title, int quantity, String subject){
        super(itemId, title, quantity);
        this.subject =subject;
    }

    @Override
    public void displayDetails() {
        System.out.println("Reference Book");
        displayCommonDetails();
        System.out.println("Subject : "+ subject);
    }
}
