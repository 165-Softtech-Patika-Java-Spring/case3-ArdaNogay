package softtech.softtechspringboot.Exception.UserException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import softtech.softtechspringboot.Enum.BaseErrorMessage;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UserInformationMustBeUniqueException extends RuntimeException{

    public UserInformationMustBeUniqueException(BaseErrorMessage message) {
        super(message.getMessage());
    }
}
