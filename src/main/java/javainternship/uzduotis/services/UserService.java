package javainternship.uzduotis.services;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    Book takingBook(Book book, int days, Long userId) throws IOException;
}
