package softtech.softtechspringboot.Exception.CommentException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class NoUserCommentsFoundException extends RuntimeException{

    private final String name;
    private final String surname;

    @Override
    public String getMessage() {
        return name + " " + surname + " hasn't left any comments yet.";
    }
}
