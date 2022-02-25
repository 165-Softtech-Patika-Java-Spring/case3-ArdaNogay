package softtech.softtechspringboot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softtech.softtechspringboot.Dto.CommentResponseDto;
import softtech.softtechspringboot.Dto.CommentSaveRequestDto;
import softtech.softtechspringboot.Entity.Comment;
import softtech.softtechspringboot.Service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/byUserId/{userId}")
    public ResponseEntity getCommentsByUserId(@PathVariable("userId") Long userId){

        List<CommentResponseDto> commentResponseDtoList = commentService.getCommentsByUserId(userId);
        return ResponseEntity.ok(commentResponseDtoList);
    }

    @GetMapping("/byProductId/{productId}")
    public ResponseEntity getCommentsByProductId(@PathVariable("productId") Long productId){

        List<CommentResponseDto> commentResponseDtoList = commentService.getCommentsByProductId(productId);
        return ResponseEntity.ok(commentResponseDtoList);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CommentSaveRequestDto commentSaveRequestDto){

        CommentResponseDto commentResponseDto = commentService.save(commentSaveRequestDto);
        return ResponseEntity.ok(commentResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){

        commentService.delete(id);
        return ResponseEntity.ok(Void.TYPE);
    }

}
