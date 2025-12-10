    package fr.tours.etu.boiteletre.Controller;

    import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthDTO;
    import fr.tours.etu.boiteletre.DTO.DtoForAuth.AuthResponseDTO;
    import fr.tours.etu.boiteletre.Service.AuthService;
    import fr.tours.etu.boiteletre.Service.UserService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    /**
     * @ClassName AuthController
     * @Description TODO
     * @Author MERABTENE
     * @Date 09/12/2025 01:13
     * @Version 1.0
     */
    @RestController
    @RequestMapping("api/auth")
    @RequiredArgsConstructor
    public class AuthController {
        private final UserService userService;
        private final AuthService authService;

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody AuthDTO userDTO){

                AuthResponseDTO user=authService.authenticate(userDTO.getUsername(), userDTO.getPassword());
                if (user==null){
                    return ResponseEntity.status(401).body("Invalid username or password !");
                }

                return ResponseEntity.ok(user);
        }


    }