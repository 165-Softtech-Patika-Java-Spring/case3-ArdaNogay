package softtech.softtechspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softtech.softtechspringboot.Entity.Comment;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment,Long> {

    List<Comment> getCommentsByProductId(Long id);
    List<Comment> getCommentsByUserId(Long id);

}
