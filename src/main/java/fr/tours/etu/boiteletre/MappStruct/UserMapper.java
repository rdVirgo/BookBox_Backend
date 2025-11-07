package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToDto(User user);
    User dtoToUser(UserDTO userDTO);
}
