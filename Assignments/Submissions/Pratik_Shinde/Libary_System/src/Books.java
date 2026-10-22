public class Books extends LibraryItem{
    private final String author;
    private boolean borrowed = false;

    Books(String title, String author){
        super(title);
        this.author = author;
    }

    public String borrowItem() throws Invalid_input{
        if (isBorrowed()){
            throw new Invalid_input("Not available");
        }

        borrowed = true;
        return "book issued";
    }

    public String returnItem() throws Invalid_input{
        if (!isBorrowed()){
            throw new Invalid_input("is already been returned");
        }

        borrowed = false;
        return "";
    }

    public boolean isBorrowed(){
        return borrowed;
    }

    public void displayDetails() {
        System.out.println("id : "+getItemID() +"\nTitle : "+getTitle()+"\nAuthor : " +author);
    }
}
