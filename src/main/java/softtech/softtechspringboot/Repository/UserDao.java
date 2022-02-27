package softtech.softtechspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softtech.softtechspringboot.Entity.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByName(String name);
    User findByPhoneNumber (String phoneNumber);

    @Query("select name from User")
    List<String> findNames();

    @Query("select phoneNumber from User")
    List<String> findPhoneNumbers();

    @Query("select email from User")
    List<String> findEmails();
}
