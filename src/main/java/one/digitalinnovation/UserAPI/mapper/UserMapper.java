package one.digitalinnovation.UserAPI.mapper;

import one.digitalinnovation.UserAPI.dto.request.UserDTO;
import one.digitalinnovation.UserAPI.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-YYYY")
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);
}
