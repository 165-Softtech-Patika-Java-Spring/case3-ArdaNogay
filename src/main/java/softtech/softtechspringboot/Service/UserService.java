package softtech.softtechspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.softtechspringboot.Converter.UserMapper;
import softtech.softtechspringboot.Dto.UserDeleteDto;
import softtech.softtechspringboot.Dto.UserSaveRequestDto;
import softtech.softtechspringboot.Entity.User;
import softtech.softtechspringboot.Repository.UserDao;
//import softtech.softtechspringboot.Service.EntityService.UserEntityService;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

//    private final UserEntityService userEntityService;

    private final UserDao dao;

    public List<UserSaveRequestDto> findAll() {
        List<User> userList = dao.findAll();
        List<UserSaveRequestDto> userSaveRequestDtoList = UserMapper.INSTANCE.convertToUserSaveRequestDtoList(userList);
        return userSaveRequestDtoList;
    }

    public UserSaveRequestDto findById(Long id) {
        User user = dao.getById(id);
        UserSaveRequestDto userSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return userSaveRequestDto;
    }

    public UserSaveRequestDto save(UserSaveRequestDto userSaveRequestDto) {
        User user = UserMapper.INSTANCE.convertToUser(userSaveRequestDto);
        user = dao.save(user);
        UserSaveRequestDto willBeReturnedUserSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return willBeReturnedUserSaveRequestDto;
    }

    public UserSaveRequestDto findByName(String name) {
        User user = dao.findByName(name);
        UserSaveRequestDto userSaveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return userSaveRequestDto;
    }

    public void delete(UserDeleteDto userDeleteDto) {
        User userFromPhone = dao.findByPhoneNumber(userDeleteDto.getPhoneNumber());
        User userFromName = dao.findByName(userDeleteDto.getName());
        if(dao.getById(userFromPhone.getId())==null){
            throw new EntityNotFoundException("The user you gave the input value was not found!");
        }
        else if(dao.getById(userFromName.getId())==null){
            throw new EntityNotFoundException("The user you gave the input value was not found!");
        }else if (userFromPhone.getId()!=userFromName.getId()){
            throw new IllegalArgumentException("Username " + userDeleteDto.getName()+
                    " and phone number " + userDeleteDto.getPhoneNumber()+ " do not match.");
        }
        dao.delete(userFromPhone);
    }

    public UserSaveRequestDto update(Long id, UserSaveRequestDto userSaveRequestDto) {
        User user = dao.getById(id);
        user.setName(userSaveRequestDto.getName());
        user.setSurname(userSaveRequestDto.getSurname());
        user.setEmail(userSaveRequestDto.getEmail());
        user.setPhoneNumber(userSaveRequestDto.getPhoneNumber());
        user.setUserType(userSaveRequestDto.getUserType());

        UserSaveRequestDto saveRequestDto = UserMapper.INSTANCE.convertToUserSaveRequestDto(user);
        return saveRequestDto;
    }
}
