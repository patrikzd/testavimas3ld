package javainternship.uzduotis.services;

import javainternship.uzduotis.Files.WritingUsers;
import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.Repositories.BookRepository;
import javainternship.uzduotis.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;

    public UserServiceImpl(UserRepository userRepository, BookRepository bookRepository, BookService bookService) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Book takingBook(Book book, int days, Long userId) throws IOException {
        User user = userRepository.getById(userId);
        if (book.getStatus().equalsIgnoreCase("present") && user.getBooksTaken()<3){
            book.setStatus(days, userId);
            bookService.addBook(book);
            user.addABook();
            userRepository.save(user);
            WritingUsers writingUsers = new WritingUsers(userRepository);
            writingUsers.writingToFileUsers();
            return book;
        }
        else{
            System.out.println("The book is either taken, or you have reached your limit");
            return null;
        }

    }
}