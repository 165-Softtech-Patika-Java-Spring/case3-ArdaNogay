package softtech.softtechspringboot.Exception.CommentException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class NoProductCommentsFoundException extends RuntimeException{

    private final String productName;

    @Override
    public String getMessage() {
        return "There are no comments for " + productName +" product yet.";
    }
}
