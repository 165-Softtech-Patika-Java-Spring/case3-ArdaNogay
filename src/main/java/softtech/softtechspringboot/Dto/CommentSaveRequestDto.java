package softtech.softtechspringboot.Dto;

import lombok.Data;

@Data
public class CommentSaveRequestDto {

    private Long userId;
    private Long productId;
    private String message;
}
