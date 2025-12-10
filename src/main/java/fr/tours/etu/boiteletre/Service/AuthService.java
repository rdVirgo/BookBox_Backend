package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthDTO;
import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthResponseDTO;
import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName AuthService
 * @Description TODO
 * @Author MERABTENE
 * @Date 09/12/2025 21:40
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor


public class AuthService {
   private final UserRepository userRepository;

    public  AuthResponseDTO authenticate(String LoginName, String password) {
        Optional<User> userop = userRepository.findByUsername(LoginName);
        if (userop.isPresent()) {
            User user = userop.get();

            if (user.getPassword().equals(password)) {
                return new AuthResponseDTO(user.getUsername());
            }
        }
        return null;
    }
}