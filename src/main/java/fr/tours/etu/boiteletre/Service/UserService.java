package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserById(int id) {
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
    }

    public User UpdateUser(User user , int id) {
        return userRepository.findById(id).map(users ->{
            user.setName(user.getName());
            user.setSurname(user.getSurname());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
            user.setUsername(user.getUsername());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

}
