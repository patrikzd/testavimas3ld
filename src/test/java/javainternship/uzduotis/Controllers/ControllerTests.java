package javainternship.uzduotis.Controllers;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.Repositories.BookRepository;
import javainternship.uzduotis.Repositories.UserRepository;
import javainternship.uzduotis.services.BookService;
import javainternship.uzduotis.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    private User u1 = new User((long)1,"Patrikas",0);
    private ArrayList<User> users = new ArrayList<User>();

    private Book b1 = new Book((long)1, "testKnyga", "Fantasy", "English", "1970-10-20", 155, "present", "Wolf", 0, 0);
    private Book b3 = new Book((long)3, "testKnyga3", "Real-Life", "Lithuanian", "1970-12-20", 157, "taken", "Mouse", 50, 2);
    private ArrayList<Book> books = new ArrayList<Book>();


    @Test
    public void findAllUsers() throws Exception {
        users.add(u1);
        Mockito.when(userService.getAllUsers()).thenReturn(users);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/user").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("result is: " + result.getResponse().getContentAsString());
        String expected = "[{id:1, name:Patrikas, booksTaken:0}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
    @Test
    public void getAllBooks() throws Exception {
        books.add(b1);
        Mockito.when(bookService.findAllBooks()).thenReturn(books);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/books").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("result is: " + result.getResponse().getContentAsString());
        String expected = "[{name:testKnyga, category:Fantasy, language:English, publicationDate:1970-10-20, isbn:155, status:present, author:Wolf, daysTaken:0, takenUserId:0}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
    @Test
    public void getBookByLanguage() throws Exception {
        books.add(b1);
        Mockito.when(bookService.findAllBooks()).thenReturn(books);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/books?language=English").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("result is: " + result.getResponse().getContentAsString());
        String expected = "[{name:testKnyga, category:Fantasy, language:English, publicationDate:1970-10-20, isbn:155, status:present, author:Wolf, daysTaken:0, takenUserId:0}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
    @Test
    public void savedBookHasAuthor() throws Exception {
        books.add(b3);
        assertEquals(books.get(0).getAuthor().isEmpty(), false);
    }

    @Test
    public void getTakeBook() throws Exception {
        books.add(b3);
        users.add(u1);
        assertEquals(userService.takingBook(b3, 20, (long)1), null);
    }
}