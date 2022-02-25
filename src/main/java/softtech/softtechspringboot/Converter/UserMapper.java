package softtech.softtechspringboot.Converter;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import softtech.softtechspringboot.Dto.UserSaveRequestDto;
import softtech.softtechspringboot.Entity.User;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserSaveRequestDto convertToUserSaveRequestDto(Optional<User> user);
    UserSaveRequestDto convertToUserSaveRequestDto(User user);

    List<UserSaveRequestDto> convertToUserSaveRequestDtoList(List<User> userList);

    User convertToUser(UserSaveRequestDto userSaveRequestDto);
}