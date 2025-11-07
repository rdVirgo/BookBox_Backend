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

            return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseUserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.UpdateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
            userService.deleteUser(id);
    }
}
