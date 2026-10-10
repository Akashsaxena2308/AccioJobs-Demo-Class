abstract class LibraryItem {
    private int item_ID;
    private String item_Name;

    public LibraryItem(int item_ID, String item_Name) {
        this.item_ID = item_ID;
        this.item_Name = item_Name;
    }

    public int getItem_ID() {
        return item_ID;
    }

    public String getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public abstract void displayDetails();
}
