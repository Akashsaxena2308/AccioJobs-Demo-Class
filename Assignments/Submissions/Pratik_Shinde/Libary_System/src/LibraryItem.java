import java.util.UUID;

public abstract class LibraryItem implements Borrowable{
    private final String itemID;
    private final String title;
    LibraryItem(String title){
        this.itemID = UUID.randomUUID().toString();
        this.title = title;
    }

    public String getItemID(){
        return itemID;
    }

    public String getTitle(){
        return title;
    }

    public abstract void displayDetails();
}
