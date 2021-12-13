package javainternship.uzduotis.Files;

import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.Repositories.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WritingUsers {
    private UserRepository userRepository;
    private FileWriter file;

    public WritingUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void writingToFileUsers(){
        JSONArray array = new JSONArray();
        for (User a: userRepository.findAll()){
            JSONObject obj = new JSONObject();
            obj.put("id", a.getId());
            obj.put("name", a.getName());
            obj.put("booksTaken", a.getBooksTaken());
            array.add(obj);
            try {
                file = new FileWriter("users.txt");
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
