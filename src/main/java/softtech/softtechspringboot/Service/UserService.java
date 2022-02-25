package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Converter.UserMapper;
import softtech.softtechspringboot.Dto.UserDeleteDto;
import softtech.softtechspringboot.Dto.UserSaveRequestDto;
import softtech.softtechspringboot.Entity.User;
import softtech.softtechspringboot.Service.EntityService.UserEntityService;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
        Optional<User> user = userEntityService.findById(id);
        UserSaveRequestDto userSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return userSaveRequestDto;
    }

    public UserSaveRequestDto save(UserSaveRequestDto userSaveRequestDto) {
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        user = userEntityService.save(user);
        UserSaveRequestDto willBeReturnedUserSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return willBeReturnedUserSaveRequestDto;
    }

    public UserSaveRequestDto findByName(String name) {
        User user = userEntityService.findByName(name);
        UserSaveRequestDto userSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return userSaveRequestDto;
    }

    public void delete(UserDeleteDto userDeleteDto) {
        User userFromPhone = userEntityService.findByPhoneNumber(userDeleteDto.getPhoneNumber());
        User userFromName = userEntityService.findByName(userDeleteDto.getName());
        if(!userEntityService.existById(userFromPhone.getId())){
            throw new EntityNotFoundException("The user you gave the input value was not found!");
        }
        else if(!userEntityService.existById(userFromName.getId())){
            throw new EntityNotFoundException("The user you gave the input value was not found!");
        }else if (userFromPhone.getId()!=userFromName.getId()){
            throw new IllegalArgumentException("Username " + userDeleteDto.getName()+
                    " and phone number " + userDeleteDto.getPhoneNumber()+ " do not match.");
        }
        userEntityService.delete(userFromPhone);
    }

    public UserSaveRequestDto update(Long id, UserSaveRequestDto userSaveRequestDto) {
        User user = userEntityService.getById(id);
        user.setName(userSaveRequestDto.getName());
        user.setSurname(userSaveRequestDto.getSurname());
        user.setEmail(userSaveRequestDto.getEmail());
        user.setPhoneNumber(userSaveRequestDto.getPhoneNumber());
        user.setUserType(userSaveRequestDto.getUserType());

        UserSaveRequestDto saveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return saveRequestDto;
    }
}
