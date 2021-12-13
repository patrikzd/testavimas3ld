package javainternship.uzduotis.services;

import javainternship.uzduotis.Objects.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> findBookByAuthor(String author);
    List<Book> findBookByLanguage(String language);
    Book findBookById(Long id);
    Book findBookByName(String name);
    List<Book> findBookByStatus (String status);
    Book findBookByISBN(int isbn);
    Book addBook (Book book);
    void deleteBook (Book book);
}
