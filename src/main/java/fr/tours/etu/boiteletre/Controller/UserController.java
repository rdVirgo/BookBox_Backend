package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.DTO.DtoForUser.ResponseUserDTO;
import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *  A controller class for the User entity.
 * It contains  the crud operations for the user side.
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */

@RestController
@CrossOrigin("*")
@RequestMapping ("api/users")
@RequiredArgsConstructor
public class UserController {
    /**
     * a parameter for the User service
     */
    private final UserService userService;

    /**
     * Creates a new user.
     *
     * @param userDTO a DTO object containing information about the user to be created.
     * @return A ResponseUserDTO containing details of the created user.
     */
    @PostMapping
    public ResponseUserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    /**
     * Retrieves all the existing users in the database.
     * @return a list of the users (ResponseUser entities)  found in the database
     */
    @GetMapping
    public List<ResponseUserDTO> getAllUser() {
     return userService.getAllUser();
}

    /**
     * Retrieves the user of the given parameter ID
     * @param id the id of the user
     * @return A ResponseUserDTO containing the specific coordinate with its details
     */
    @GetMapping("/{id}")
    public ResponseUserDTO getUserById(@PathVariable int id) {

            return userService.getUserById(id);
    }

    /**
     * Update a specific user selected by its ID
     * @param id the id parameter of the user to update
     * @param userDTO the user containing the new information of a user .
     * @return a ResponseUserDTO containing the user updated with the new information
     */
    @PutMapping("/{id}")
    public ResponseUserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.UpdateUser(id, userDTO);
    }

    /**
     * delete the user corresponding to the id selected
     * @param id the id of the user to remove
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
            userService.deleteUser(id);
    }
}
