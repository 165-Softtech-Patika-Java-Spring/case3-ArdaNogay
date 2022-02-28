package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import softtech.softtechspringboot.Converter.CommentMapper;
import softtech.softtechspringboot.Dto.CommentResponseDto;
import softtech.softtechspringboot.Dto.CommentSaveRequestDto;
import softtech.softtechspringboot.Entity.Comment;
import softtech.softtechspringboot.Entity.Product;
import softtech.softtechspringboot.Entity.User;
import softtech.softtechspringboot.Service.EntityService.CommentEntityService;
import softtech.softtechspringboot.Service.EntityService.ProductEntityService;
import softtech.softtechspringboot.Service.EntityService.UserEntityService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserEntityService userEntityService;
    private final ProductEntityService productEntityService;
    private final CommentEntityService commentEntityService;

    public List<CommentResponseDto> getCommentsByUserId(Long userId){
        List<Comment> commentList = commentEntityService.getByUserId(userId);
        commentValidationByUserId(userId, commentList);
        List<CommentResponseDto> commentResponseDtoList = CommentMapper.INSTANCE.convertToCommentResponseDtoList(commentList);
        return  commentResponseDtoList;
    }

    private void commentValidationByUserId(Long userId, List<Comment> commentList) {
        if(commentList.isEmpty()){
            User user = userEntityService.getById(userId);
            throw new NotFoundException(user.getName()+ " " + user.getSurname() + " hasn't left any comments yet." );
        }
    }

    public List<CommentResponseDto> getCommentsByProductId(Long productId){
        List<Comment> commentList = commentEntityService.getByProductId(productId);
        commentValidationByProductId(productId, commentList);
        List<CommentResponseDto> commentResponseDtoList = CommentMapper.INSTANCE.convertToCommentResponseDtoList(commentList);
        return  commentResponseDtoList;
    }

    private void commentValidationByProductId(Long productId, List<Comment> commentList) {
        if(commentList.isEmpty()){
            Product product = productEntityService.getById(productId);
            throw new NotFoundException("There are no comments for " + product.getName() +" product yet.");
        }
    }

    public CommentResponseDto save(CommentSaveRequestDto commentSaveRequestDto) {
        Comment comment = CommentMapper.INSTANCE.convertToComment(commentSaveRequestDto);
        comment = commentEntityService.save(comment);
        CommentResponseDto commentResponseDto = CommentMapper.INSTANCE.convertToCommentResponseDto(comment);
        return commentResponseDto;
    }

    public void delete(Long id){
        Comment comment = commentEntityService.getById(id);
        commentEntityService.delete(comment);
    }
}
