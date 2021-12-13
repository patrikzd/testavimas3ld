package javainternship.uzduotis.Repositories;

import javainternship.uzduotis.Objects.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
