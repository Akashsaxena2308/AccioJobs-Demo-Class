package question_5;

import java.util.UUID;

public class Book {
    private String title;
    private String author;
    private String ISBN;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    Book(String title, String author){
        this.title = title;
        this.author = author;
        this.ISBN = UUID.randomUUID().toString();
    }
}
