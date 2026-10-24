package BookStore;

public class Book {
    private final long id;
    private final String title;
    private final String Author;
    private final double price;

    public Book(long id,String title,String Author,double price){
        this.id=id;
        this.title=title;
        this.Author=Author;
        this.price=price;
    }
    public long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return Author;
    }
    public double getPrice(){
        return price;
    }
}
