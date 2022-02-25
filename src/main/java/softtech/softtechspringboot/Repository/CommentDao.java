package softtech.softtechspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softtech.softtechspringboot.Entity.Comment;

@Repository
public interface CommentDao extends JpaRepository<Comment,Long> {
}
