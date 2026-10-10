package Library;

public class ReferenceBook extends LibraryItem {

    private final String subject;

    ReferenceBook(String itemId, String title, String subject){
        super(itemId, title);
        this.subject = subject;
    }


    public String getSubject() {
        return subject;
    }

    public String specificDetails(){
        return "Reference Book | Subject : " + getSubject();
    }
}
