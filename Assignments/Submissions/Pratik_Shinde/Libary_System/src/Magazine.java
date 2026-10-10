import java.util.UUID;

public class Magazine extends LibraryItem{
    private final String issueNumber;
    private boolean borrowed = false;

    Magazine(String title){
        super(title);
        this.issueNumber = UUID.randomUUID().toString();
    }

    public String borrowItem() throws Invalid_input{
        if (isBorrowed()){
            throw new Invalid_input("Not Available");
        }

        borrowed = true;
        return "is issued";
    }

    public String returnItem() throws Invalid_input{
        if (!isBorrowed()){
            throw new Invalid_input("is already returned");
        }

        borrowed = false;
        return "returned successfully";
    }

    public boolean isBorrowed(){
        return borrowed;
    }

    @Override
    public void displayDetails() {
        System.out.println("-----------------------------------------");
        System.out.println("Name of magazine : " + getTitle() + "\nIssue number : "+issueNumber);
    }

}
