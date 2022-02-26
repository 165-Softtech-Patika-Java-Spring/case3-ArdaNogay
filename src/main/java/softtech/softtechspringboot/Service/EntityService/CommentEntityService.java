//package softtech.softtechspringboot.Service.EntityService;
//
//import org.springframework.stereotype.Service;
//import softtech.softtechspringboot.Entity.Comment;
//import softtech.softtechspringboot.Entity.Product;
//import softtech.softtechspringboot.Repository.CommentDao;
//import softtech.softtechspringboot.Service.BaseEntityService;
//
//import java.util.List;
//
//@Service
//public class CommentEntityService extends BaseEntityService<Comment, CommentDao> {
//
//    public CommentEntityService(CommentDao dao) {
//        super(dao);
//    }
//
//    public List<Comment> getByUserId(Long userId){
//        return getDao().getCommentsByUserId(userId);
//    }
//
//    public List<Comment> getByProductId(Long productId){
//        return getDao().getCommentsByProductId(productId);
//    }
//
//    public Comment getById(Long id) {
//        return getDao().getById(id);
//    }
//}
