package fr.tours.etu.boiteletre.DTO.DtoForUser;
import fr.tours.etu.boiteletre.Model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  A dto class for the User entity .
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
        */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
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
     * password : string a password for the user account
     */
    private String password;
    /**
     * username : string -> the user's name in the application
     */
    private String username;

    private Role role;

}
