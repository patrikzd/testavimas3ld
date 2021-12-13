package javainternship.uzduotis.Files;

import com.google.gson.Gson;
import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.Repositories.BookRepository;
import javainternship.uzduotis.Repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Component
public class Reading {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public Reading(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public BookRepository readingFromFile() throws FileNotFoundException {
        System.out.println("Loading Book Data");
        try (Reader reader = new FileReader("books.txt")) {
            Gson gson = new Gson();
            Book[] books = gson.fromJson(reader, Book[].class);
            for(Book a: books){
                bookRepository.save(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookRepository;
    }
    public UserRepository readingFromFileUser() throws FileNotFoundException {
        System.out.println("Loading User Data");
        try (Reader reader = new FileReader("users.txt")) {
            Gson gson = new Gson();
            User[] users = gson.fromJson(reader, User[].class);
            for(User a: users){
                userRepository.save(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userRepository;
    }
}