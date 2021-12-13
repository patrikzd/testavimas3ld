package javainternship.uzduotis.Files;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.Repositories.BookRepository;
import javainternship.uzduotis.Repositories.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class Initializing implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final Reading reading;
    private static FileWriter file;

    public Initializing(BookRepository bookRepository, UserRepository userRepository, Reading reading) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.reading = reading;
    }

    @Override
    public void run(String... args) throws Exception {
        reading.readingFromFile();
        reading.readingFromFileUser();

    }
}