package Library;

public class Magazine extends BorrowableItem{
    private final String issueNo;

    Magazine(String itemId, String title, String issueNo){
        super(itemId, title);
        this.issueNo = issueNo;
    }


    public String getIssueNo() {
        return issueNo;
    }

    public String specificDetails(){
        return "Magazine | IssueNo : " + issueNo;
    }
}
