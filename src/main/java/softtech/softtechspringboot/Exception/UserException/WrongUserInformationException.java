package softtech.softtechspringboot.Exception.UserException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
public class WrongUserInformationException extends  RuntimeException{

    private final String userInformation;

    @Override
    public String getMessage() {
        return "The user you gave the input (" + userInformation + ") value was not found!";
    }
}
