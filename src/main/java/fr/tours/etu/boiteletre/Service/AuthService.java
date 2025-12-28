package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthDTO;
import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthResponseDTO;
import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @ClassName AuthService
 * @Description a service to handle the authentication
 * @Author MERABTENE
 * @Date 09/12/2025 21:40
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor


public class AuthService {
   private final UserRepository userRepository;
   private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    /**
     * a method to authenticate a user
     * @param LoginName username of the user
     * @param password it's password
     * @return a Authdto with the generated token
     */
    public  AuthResponseDTO authenticate(String LoginName, String password) {
        User user= userRepository.findByUsername(LoginName).orElseThrow(()->new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        // generate the token for the session
        String token = jwtService.generateToken(user);
        return  new AuthResponseDTO(
                token,
                user.getUsername(),
                user.getRole()
        );
    }


}