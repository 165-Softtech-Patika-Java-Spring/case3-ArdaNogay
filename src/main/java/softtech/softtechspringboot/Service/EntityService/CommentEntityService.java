package softtech.softtechspringboot.Service.EntityService;

import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Entity.Comment;
import softtech.softtechspringboot.Repository.CommentDao;
import softtech.softtechspringboot.Service.BaseEntityService;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentDao> {

    public CommentEntityService(CommentDao dao) {
        super(dao);
    }
}
