    package fr.tours.etu.boiteletre.Controller;

    import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthDTO;
    import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthResponseDTO;
    import fr.tours.etu.boiteletre.Service.AuthService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    /**
     * @ClassName AuthController
     * @Description a controller containing the methods to authenticate a user (only an existing user
     * car login to the app different from user controller)
     * @Author Rdvirgo & Mamadou COULIBALY
     * @Date 09/12/2025 01:13
     * @Version 1.0
     */
    @RestController
    @CrossOrigin("*")
    @RequestMapping("api/auth")
    @RequiredArgsConstructor
    public class AuthController {
        private final AuthService authService;

        @PostMapping("/login")
        /**
         * a method to authenticate a user for the login form
         * @RequestBody the user data to authenticate
         */
        public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO userDTO){

                AuthResponseDTO user=authService.authenticate(userDTO.getUsername(), userDTO.getPassword());
                return ResponseEntity.ok(user);
        }


    }
