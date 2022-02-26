package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Converter.CommentMapper;
import softtech.softtechspringboot.Dto.CommentResponseDto;
import softtech.softtechspringboot.Dto.CommentSaveRequestDto;
import softtech.softtechspringboot.Entity.Comment;
import softtech.softtechspringboot.Repository.CommentDao;
//import softtech.softtechspringboot.Service.EntityService.CommentEntityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentDao commentEntityService;


    public List<CommentResponseDto> getCommentsByUserId(Long userId){
        List<Comment> commentList = commentEntityService.getCommentsByUserId(userId);
        List<CommentResponseDto> commentResponseDtoList = CommentMapper.INSTANCE.convertToCommentResponseDtoList(commentList);
        return  commentResponseDtoList;
    }

    public List<CommentResponseDto> getCommentsByProductId(Long productId){
        List<Comment> commentList = commentEntityService.getCommentsByProductId(productId);
        List<CommentResponseDto> commentResponseDtoList = CommentMapper.INSTANCE.convertToCommentResponseDtoList(commentList);
        return  commentResponseDtoList;
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
