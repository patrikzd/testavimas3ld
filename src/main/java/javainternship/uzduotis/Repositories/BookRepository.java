package javainternship.uzduotis.Repositories;

import javainternship.uzduotis.Objects.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.FileNotFoundException;

public interface BookRepository extends JpaRepository<Book, Long> {
}
