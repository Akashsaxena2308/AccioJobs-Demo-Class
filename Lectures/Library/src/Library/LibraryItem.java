package Library;

public abstract class LibraryItem {
    private final String itemId;
    private final String title;

    LibraryItem(String itemId, String title){
       this.itemId = itemId;
       this.title = title;
    }

    public String getItemId(){
        return itemId;
    }

    public String getTitle(){
        return title;
    }

    abstract String specificDetails();

    public final void displayDetails(){
        System.out.println(itemId + " | "  + title + " | " + specificDetails());
    }
}


//Parent ---> Library ITem ---> specificDetails --> Abstract
//BorrowableItem  --> specificDetails --> Abstract
