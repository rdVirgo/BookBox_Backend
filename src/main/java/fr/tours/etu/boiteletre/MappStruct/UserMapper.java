package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Model.User;
import org.mapstruct.Mapper;
/**
 *  A mapper for the user entity
 * convert a user to userDTO
 * covert a userDTO to a user
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * convert a user to a userDTO
     * @param user
     * @return userDTO
     */
    UserDTO userToDto(User user);

    /**
     * convert a userDTO to a user
     * @param userDTO
     * @return user
     */
    User dtoToUser(UserDTO userDTO);
}
