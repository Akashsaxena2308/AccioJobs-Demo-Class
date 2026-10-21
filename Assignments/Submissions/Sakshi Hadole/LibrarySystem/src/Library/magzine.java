package Library;

public class magzine extends BorrowableItem{
    public String issueNo;

    magzine(String itemId,String title,String issueNo){
        super(itemId, title);
        this.issueNo=issueNo;
    }
    @Override
    public void specificDetails(){
        System.out.println("Issue Number |" +issueNo);
    }
}
