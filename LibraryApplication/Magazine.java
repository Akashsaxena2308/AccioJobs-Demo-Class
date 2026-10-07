package LibraryApplication;

public class Magazine extends BorrowItem{

    private int serialNumber;
    public Magazine(int itemId, String title, int quantity, int serialNumber){
        super(itemId, title, quantity);
        this.serialNumber = serialNumber;
    }
    @Override
    public void displayDetails() {
        System.out.println("Magazine");
        displayCommonDetails();
        System.out.println("Serial Number : "+serialNumber);
    }

}
