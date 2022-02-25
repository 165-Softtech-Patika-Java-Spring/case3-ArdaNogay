package softtech.softtechspringboot.Dto;

import lombok.Data;
import softtech.softtechspringboot.Enum.UserType;

@Data
public class UserSaveRequestDto {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private UserType userType;
}
