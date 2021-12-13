package javainternship.uzduotis.services;

import javainternship.uzduotis.Files.WritingBooks;
import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<Book>();
        for(Book a : findAllBooks()){
            if (a.getAuthor().equalsIgnoreCase(author)) booksByAuthor.add(a);
        }
        if (!booksByAuthor.isEmpty()) return booksByAuthor;
        return null;
    }

    @Override
    public List<Book> findBookByLanguage(String language) {
        List<Book> booksByLanguage = new ArrayList<Book>();
        for(Book a : findAllBooks()){
            if (a.getLanguage().equalsIgnoreCase(language)) booksByLanguage.add(a);
        }
        if (!booksByLanguage.isEmpty()) return booksByLanguage;
        return null;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book findBookByName(String name) {
        for(Book a : findAllBooks()){
            if (a.getName().equalsIgnoreCase(name)) return a;
        }
        return null;
    }

    @Override
    public List<Book> findBookByStatus(String status) {
        List<Book> booksByStatus = new ArrayList<Book>();
        for(Book a : findAllBooks()){
            if (a.getStatus().equalsIgnoreCase(status)) booksByStatus.add(a);
        }
        if (!booksByStatus.isEmpty()) return booksByStatus;
        return null;
    }

    @Override
    public Book findBookByISBN(int isbn) {
        for(Book a : findAllBooks()){
            if (a.getIsbn()==isbn) return a;
        }
        return null;
    }

    @Override
    public Book addBook(Book book) {

        bookRepository.save(book);
        WritingBooks writing= new WritingBooks(bookRepository);
        writing.writingToFileBooks();
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
        WritingBooks writing= new WritingBooks(bookRepository);
        writing.writingToFileBooks();
    }
}