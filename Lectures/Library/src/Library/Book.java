package Library;

public class Book extends BorrowableItem{

    private final String author;

    Book(String itemId, String title, String author){
        super(itemId, title);
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    public String specificDetails(){
        return "Book | Author : " + author;
    }
}
