package softtech.softtechspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softtech.softtechspringboot.Entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByName(String name);
    User findByPhoneNumber (String phoneNumber);
}
