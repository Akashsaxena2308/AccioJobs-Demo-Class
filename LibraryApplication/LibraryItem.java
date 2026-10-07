package LibraryApplication;

public abstract class LibraryItem {
    private int itemId;
    private String title;
    private int quantity;

    LibraryItem(int itemId, String title, int quantity){
        this.itemId = itemId;
        this.title = title;
        this.quantity = quantity;
    }

    public int getItemId(){
        return itemId;
    }

    public String getTitle(){
        return title;
    }

    public int getQuantity(){
        return quantity;
    }

    public void displayCommonDetails(){
        System.out.println("Item ID : "+itemId);
        System.out.println("Title   : "+title);
        System.out.println("Quantity : "+quantity);
    }

    public abstract void displayDetails();

    public void increaseQuantity(){
        quantity++;
    }

    public void decreaseQuantity(){
        quantity--;
    }

}
