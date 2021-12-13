package javainternship.uzduotis.Files;

import javainternship.uzduotis.Objects.Book;
import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.Repositories.BookRepository;
import javainternship.uzduotis.Repositories.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WritingBooks {
    private BookRepository bookRepository;
    private FileWriter file;

    public WritingBooks(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void writingToFileBooks(){
        JSONArray array = new JSONArray();
        for (Book a: bookRepository.findAll()){
            JSONObject obj = new JSONObject();
            obj.put("guid", a.getGuid());
            obj.put("name", a.getName());
            obj.put("category", a.getCategory());
            obj.put("language", a.getLanguage());
            obj.put("publicationDate", a.getPublicationDate());
            obj.put("isbn", a.getIsbn());
            obj.put("status", a.getStatus());
            obj.put("author", a.getAuthor());
            obj.put("daysTaken", a.getDaysTaken());
            obj.put("takenUserId", a.getTakenUserId());
            array.add(obj);
            try {
                file = new FileWriter("books.txt");
                file.write(array.toJSONString());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
