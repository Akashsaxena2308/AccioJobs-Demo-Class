package Library;

public abstract class BorrowableItem extends LibraryItem implements Borrowable{

    private boolean borrowed;

    BorrowableItem(String itemId, String title){
        super(itemId, title);

    }

    public boolean isBorrowed(){
        return borrowed;
    }

    //Borrow
    //return
    public String borrow(){
        if(borrowed){
            return "Cannot borrow : " + getTitle() + " is already borrowed!";
        }
        borrowed = true;
        return "Borrowed :" + getTitle();
    }

    public String returnItem(){
        if(!borrowed){
            return "Cannot return : " + getTitle() + "is not borrowed!";
        }

        borrowed = false;
        return "Returned : " + getTitle();
    }

    abstract String specificDetails();

}
//PARENT --> METHOD --> CHILD