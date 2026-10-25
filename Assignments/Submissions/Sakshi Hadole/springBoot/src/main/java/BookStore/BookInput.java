package BookStore;

public class BookInput {
    private String title;
    private String Author;
    private double price;

    public BookInput(){

    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getAuthor(){
        return Author;
    }
    public void setAuthor(String Author){
        this.Author=Author;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
}
