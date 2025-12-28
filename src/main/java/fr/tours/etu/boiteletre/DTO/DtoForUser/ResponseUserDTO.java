package fr.tours.etu.boiteletre.DTO.DtoForUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  A DTO for the User entity ( response part hiding the password)
 *
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDTO {
    /**
     * userId : an int unique for each user
     */
    private int userId;
    /**
     * name : String name of the user
     */
    private String name;
    /**
     * surname : String : surname of the user
     */
    private String surname;
    /**
     * email : string email of the user
     */
    private String email;
    /**
     * username : string -> the user's name in the application
     */
    private String username;

    /**
     * a specific Constructor that take a UserDTO and hides the password parameter
     * @param userDTO
     */
    public ResponseUserDTO(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
    }
}
