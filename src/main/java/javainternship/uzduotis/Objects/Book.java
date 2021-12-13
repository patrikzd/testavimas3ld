package javainternship.uzduotis.Objects;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.util.EmptyStackException;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guid;
    private String name;
    private String category;
    private String language;
    private String publicationDate;
    private int isbn;
    private String status;
    private String author;
    private int daysTaken;
    private long takenUserId;

    public Book(Long guid, String name, String category, String language, String publicationDate, int isbn, String status, String author, int daysTaken, long takenUserId) {
        this.guid = guid;
        this.name = name;
        this.category = category;
        this.language = language;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.status = status;
        this.author = author;
        this.daysTaken = daysTaken;
        this.takenUserId = takenUserId;
    }

    public Book() {
    }

    public int getDaysTaken() {
        return daysTaken;
    }

    public long getTakenUserId() {
        return takenUserId;
    }

    public void setStatus(int daysTaken, Long id) throws IOException {
        if (daysTaken<= 60){
            this.daysTaken = daysTaken;
            this.status = "Taken";
            this.takenUserId = id;
        }
        else{
            throw new IOException("You cannot take a book for longer than 3 months");
        }

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
