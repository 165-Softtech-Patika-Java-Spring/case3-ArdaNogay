package softtech.softtechspringboot.Converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import softtech.softtechspringboot.Dto.CommentResponseDto;
import softtech.softtechspringboot.Dto.CommentSaveRequestDto;
import softtech.softtechspringboot.Entity.Comment;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    List<CommentResponseDto> convertToCommentResponseDtoList(List<Comment> commentList);

    CommentResponseDto convertToCommentResponseDto(Comment comment);

    Comment convertToComment(CommentSaveRequestDto commentSaveRequestDto);
}
