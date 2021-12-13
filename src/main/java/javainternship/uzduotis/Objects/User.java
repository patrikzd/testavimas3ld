package javainternship.uzduotis.Objects;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int booksTaken;

    public User(Long id, String name, int booksTaken) {
        this.id = id;
        this.name = name;
        this.booksTaken = booksTaken;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBooksTaken() {
        return booksTaken;
    }

    public void setBooksTaken(int booksTaken) {
        this.booksTaken = booksTaken;
    }
    public void addABook(){
        this.booksTaken++;
    }
}
