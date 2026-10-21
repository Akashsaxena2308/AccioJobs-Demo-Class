package question_5;

import java.util.ArrayList;
import java.util.List;

public class Book_Collection {
    private List<Book> list;
    Book_Collection(){
        this.list = new ArrayList<>();
    }

    public void add(Book book){
        list.add(book);
    }

    public void remove(Book book){
        list.remove(book);
    }

    public void print(){
        for (Book book: list){
            System.out.println(book.getTitle()+" : "+book.getAuthor()+" : "+book.getISBN());
        }
    }
}
