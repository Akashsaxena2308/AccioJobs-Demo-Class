package Library;

public class referenceBook extends LibraryItem{
    public String subject;

    referenceBook(String itemId,String title,String subject){
        super(itemId,title);
        this.subject=subject;
    }
    @Override
    public void specificDetails(){
        System.out.println("Subject |"+subject);
    }
}
