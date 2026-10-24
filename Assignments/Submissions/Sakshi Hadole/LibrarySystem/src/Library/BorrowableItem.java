package Library;

public abstract class BorrowableItem extends LibraryItem implements Borrowable{
    private boolean borrowed;
    BorrowableItem(String ItemId, String title){
        super(ItemId,title);
    }

    @Override
    void specificDetails() {

    }

    public boolean isBorrowed(){
        return borrowed;
    }
    public String borrow(){
        if(borrowed){
            return "cannot borrowed "+ getTitle()+" is already borrowed" ;
        }
        borrowed=true;
        return getTitle()+" is borrowed";
    }

    public String returnItem(){
        if(!borrowed){
            return "cannot return "+getTitle() ;
        }
        borrowed=false;
        return "returned "+getTitle();

    }
}
