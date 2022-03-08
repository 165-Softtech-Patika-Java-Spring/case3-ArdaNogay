package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Converter.UserMapper;
import softtech.softtechspringboot.Dto.UserDeleteDto;
import softtech.softtechspringboot.Dto.UserSaveRequestDto;
import softtech.softtechspringboot.EmailFormatValidation.EmailRegex;
import softtech.softtechspringboot.Entity.User;
import softtech.softtechspringboot.Enum.BaseErrorMessage;
import softtech.softtechspringboot.Exception.UserException.UserInformationMustBeUniqueException;
import softtech.softtechspringboot.Exception.UserException.UserInformationNotMatchedException;
import softtech.softtechspringboot.Exception.UserException.WrongUserInformationException;
import softtech.softtechspringboot.Service.EntityService.UserEntityService;


import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;

    public List<UserSaveRequestDto> findAll() {
        List<User> userList = userEntityService.findAll();
        List<UserSaveRequestDto> userSaveRequestDtoList = UserMapper.INSTANCE.convertToUserSaveRequestDtoList(userList);
        return userSaveRequestDtoList;
    }

    public UserSaveRequestDto findById(Long id) {
        User user = userEntityService.getById(id);
        UserSaveRequestDto userSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return userSaveRequestDto;
    }

    public UserSaveRequestDto save(UserSaveRequestDto userSaveRequestDto) {
        nameValidation(userSaveRequestDto);
        phoneNumberValidation(userSaveRequestDto);
        emailValidation(userSaveRequestDto);
        emailFormatControl(userSaveRequestDto);
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        user = userEntityService.save(user);
        UserSaveRequestDto willBeReturnedUserSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return willBeReturnedUserSaveRequestDto;
    }

    private void emailFormatControl(UserSaveRequestDto userSaveRequestDto) {
        if(!EmailRegex.isEmailValid(userSaveRequestDto.getEmail())){
            throw new RuntimeException("Email is not in correct format!");
        }
    }


    private boolean nameValidation(UserSaveRequestDto userSaveRequestDto) {
        List<String>  nameList = userEntityService.findNames();
        for(String name : nameList){
            if(name.equals(userSaveRequestDto.getName())){
                throw new UserInformationMustBeUniqueException(BaseErrorMessage.UNIQUE_USERNAME);
            }
        }
        return true;
    }

    private boolean phoneNumberValidation(UserSaveRequestDto userSaveRequestDto) {
        List<String>  phoneNumberList = userEntityService.findPhoneNumbers();
        for(String phoneNumber : phoneNumberList){
            if(phoneNumber.equals(userSaveRequestDto.getPhoneNumber())){
                throw new UserInformationMustBeUniqueException(BaseErrorMessage.UNIQUE_PHONE_NUMBER);
            }
        }
        return true;
    }

    private boolean emailValidation(UserSaveRequestDto userSaveRequestDto) {
        List<String>  emailList = userEntityService.findEmails();
        for(String email : emailList){
            if(email.equals(userSaveRequestDto.getEmail())){
                throw new UserInformationMustBeUniqueException(BaseErrorMessage.UNIQUE_EMAIL);
            }
        }
        return true;
    }

    public UserSaveRequestDto findByName(String name) {
        User user = userEntityService.findByName(name);
        UserSaveRequestDto userSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return userSaveRequestDto;
    }

    public void delete(UserDeleteDto userDeleteDto) {
        User user = deleteValidation(userDeleteDto);
        userEntityService.delete(user);
    }

    private User deleteValidation(UserDeleteDto userDeleteDto) {
        User userFromPhone = userEntityService.findByPhoneNumber(userDeleteDto.getPhoneNumber());
        User userFromName = userEntityService.findByName(userDeleteDto.getName());
        if(userFromPhone==null){
            throw new WrongUserInformationException(userDeleteDto.getPhoneNumber());
        }
        else if(userFromName==null){
            throw new WrongUserInformationException(userDeleteDto.getName());
        }else if (userFromPhone.getId()!=userFromName.getId()){
            throw new UserInformationNotMatchedException(userDeleteDto.getName(),userDeleteDto.getPhoneNumber());
        }
        return userFromPhone;
    }

    public UserSaveRequestDto update(Long id, UserSaveRequestDto userSaveRequestDto) {
        emailFormatControl(userSaveRequestDto);
        User user = userUpdateMapping(id, userSaveRequestDto);
        UserSaveRequestDto saveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return saveRequestDto;
    }

    private User userUpdateMapping(Long id, UserSaveRequestDto userSaveRequestDto) {
        User user = userEntityService.getById(id);
        user.setName(userSaveRequestDto.getName());
        user.setSurname(userSaveRequestDto.getSurname());
        user.setEmail(userSaveRequestDto.getEmail());
        user.setPhoneNumber(userSaveRequestDto.getPhoneNumber());
        user.setUserType(userSaveRequestDto.getUserType());
        user = userEntityService.save(user);
        return user;
    }
}
