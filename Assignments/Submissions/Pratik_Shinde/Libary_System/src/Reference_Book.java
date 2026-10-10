public class Reference_Book extends LibraryItem{
    private final String subject;
    Reference_Book(String title, String subject){
        super(title);
        this.subject = subject;
    }

    public String borrowItem() throws Invalid_input{
        throw new Invalid_input("cant be issued");
    }

    public String returnItem() throws Invalid_input{
        throw new Invalid_input("cant be issued");
    }

    public boolean isBorrowed(){
        throw new Invalid_input("cant be issued");
    }

    public void displayDetails(){
        System.out.println("-----------------------------------------");
        System.out.println("Item ID : "+getItemID()+"\ntitle : "+getTitle()+" "+"\nsubject : "+subject);
    }
}
