package Library;

public abstract class LibraryItem {
    private final String ItemId;
    private final String title;

    LibraryItem(String ItemId,String title){
        this.ItemId=ItemId;
        this.title=title;
    }
    abstract void specificDetails();

    public String getTitle(){
        return title;
    }

    public final void displayDetails(){
        System.out.println(ItemId+" "+title+" ");
        specificDetails();
    }
}
