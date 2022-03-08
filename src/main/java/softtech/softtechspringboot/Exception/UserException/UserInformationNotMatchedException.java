package softtech.softtechspringboot.Exception.UserException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@RequiredArgsConstructor
public class UserInformationNotMatchedException extends RuntimeException {

    private final String name;
    private final String phoneNumber;

    public String getMessage() {
        return "Username " + name +
                " and phone number " + phoneNumber + " do not match.";
    }
}
