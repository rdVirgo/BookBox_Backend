package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
      this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
     return userService.getAll();
}

    @PostMapping
    public User createUser(@RequestBody User user) {
      return userService.createUser(user);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PutMapping
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.UpdateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

}
