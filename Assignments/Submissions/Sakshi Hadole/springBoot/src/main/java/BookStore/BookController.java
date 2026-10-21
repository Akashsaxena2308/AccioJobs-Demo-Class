package BookStore;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final List<Book> bookList = new ArrayList<>();
    long id;

    public BookController() {
        bookList.add(new Book(1, "Java", "james", 500));
        bookList.add(new Book(2, "Abcd", "jonh", 200));
        bookList.add(new Book(3, "Pqrs", "tom", 100));
    }

    // get all the books
    @GetMapping("/books")
    public List<Book> getBookList() {
        return bookList;
    }

    //get book by id
    @GetMapping("/Book/{id}")
    public Book getBook(@PathVariable long id) {
        for (Book b : bookList) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    // add a book
    @PostMapping("/books")
    public List<Book> addBook(@RequestBody BookInput input) {
        Book book = new Book(id++,
                input.getTitle(),
                input.getAuthor(),
                input.getPrice()
        );
        bookList.add(book);
        return bookList;
    }

    //update an existing book
    @PutMapping("/Update/{id}")
    public List<Book> updateById(@PathVariable long id, @RequestBody BookInput input) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                Book bookList = new Book(id, input.getTitle(), input.getAuthor(), input.getPrice());
            }
        }
        return bookList;
    }

    @DeleteMapping("/deleteBook/{id}")
    public List<Book> deleteBookById(@PathVariable long id) {
        for (Book b : bookList) {
            if (b.getId() == id) {
                bookList.remove(b);
            }
        }
        return bookList;
    }
}