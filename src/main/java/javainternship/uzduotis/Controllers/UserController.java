package javainternship.uzduotis.Controllers;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.services.BookService;
import javainternship.uzduotis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final  String BASE_URL = "/api/user";
    @Autowired
    private final UserService userService;
    @Autowired
    private  BookService bookService;


    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/taking")
    public Book takingBook(@RequestParam long bookid, @RequestParam long userid, @RequestParam int daystaken) throws IOException {
        return userService.takingBook(bookService.findBookById(bookid), daystaken, userid);
    }
}
