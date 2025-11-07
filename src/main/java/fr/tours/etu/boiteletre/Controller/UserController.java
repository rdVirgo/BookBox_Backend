package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.DTO.DtoForUser.ResponseUserDTO;
import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseUserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping
    public List<ResponseUserDTO> getAllUser() {
     return userService.getAllUser();
}

    @GetMapping("/{id}")
    public ResponseUserDTO getUserById(@PathVariable int id) {
        try{
            return userService.getUserById(id);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseUserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        try{
            return userService.UpdateUser(id, userDTO);
        }catch (RuntimeException ex){
            System.err.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        try{
            userService.deleteUser(id);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage());
        }
    }

}
