package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Converter.UserMapper;
import softtech.softtechspringboot.Dto.UserDeleteDto;
import softtech.softtechspringboot.Dto.UserSaveRequestDto;
import softtech.softtechspringboot.EmailFormatValidation.EmailRegex;
import softtech.softtechspringboot.Entity.User;
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
            throw new RuntimeException("Email doğru formatta değil!");
        }
    }


    private boolean nameValidation(UserSaveRequestDto userSaveRequestDto) {
        List<String>  nameList = userEntityService.findNames();
        for(String name : nameList){
            if(name.equals(userSaveRequestDto.getName())){
                throw new RuntimeException("Kullanıcı adı aynı olamaz!");
            }
        }
        return true;
    }

    private boolean phoneNumberValidation(UserSaveRequestDto userSaveRequestDto) {
        List<String>  phoneNumberList = userEntityService.findPhoneNumbers();
        for(String phoneNumber : phoneNumberList){
            if(phoneNumber.equals(userSaveRequestDto.getPhoneNumber())){
                throw new RuntimeException("Telefon numarası aynı olamaz!");
            }
        }
        return true;
    }

    private boolean emailValidation(UserSaveRequestDto userSaveRequestDto) {
        List<String>  emailList = userEntityService.findEmails();
        for(String email : emailList){
            if(email.equals(userSaveRequestDto.getEmail())){
                throw new RuntimeException("Email aynı olamaz!");
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
            throw new EntityNotFoundException("The user you gave the input (" + userDeleteDto.getPhoneNumber()+ ") value was not found!");
        }
        else if(userFromName==null){
            throw new EntityNotFoundException("The user you gave the input (" + userDeleteDto.getName()+ ") value was not found!");
        }else if (userFromPhone.getId()!=userFromName.getId()){
            throw new IllegalArgumentException("Username " + userDeleteDto.getName()+
                    " and phone number " + userDeleteDto.getPhoneNumber()+ " do not match.");
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
        return user; //Todo: BU UPDATE OLAYINI DEĞİŞTİR. ÇİRKİN OLDU.
    }
}
