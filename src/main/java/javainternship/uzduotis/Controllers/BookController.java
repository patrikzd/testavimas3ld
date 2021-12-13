package javainternship.uzduotis.Controllers;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {

    public static final String BASE_URL = "/api/books";
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book>getAllBooks(){
        return bookService.findAllBooks();
    }
    @GetMapping(params = "guid")
    public Book getBookById(@RequestParam("guid") final long guid){
        return bookService.findBookById(guid);
    }
    @GetMapping(params = "author")
    public List<Book> getBookByAuthor(@RequestParam("author") final String author){
        return bookService.findBookByAuthor(author);
    }
    @GetMapping(params = "language")
    public List<Book> getBookByLanguage(@RequestParam("language") final String language){
        return bookService.findBookByLanguage(language);
    }
    @GetMapping(params = "isbn")
    public Book getBookByISBN(@RequestParam("isbn") final int ISBN){
        return bookService.findBookByISBN(ISBN);
    }
    @GetMapping(params = "name")
    public Book getBookByName(@RequestParam("name") final String name){
        return bookService.findBookByName(name);
    }
    @GetMapping(params = "status")
    public List<Book> getBookByStatus(@RequestParam("status") final String status){
        return bookService.findBookByStatus(status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook (@RequestBody Book book){

        return bookService.addBook(book);
    }

    @DeleteMapping("/{guid}")
    public String deleteBook (@PathVariable long guid){
        int size = bookService.findAllBooks().size();
        bookService.deleteBook(bookService.findBookById(guid));
        if (size>bookService.findAllBooks().size()){
            return "Deleted Successfully";
        }
        return "The book was not deleted";

    }

}
