package fr.tours.etu.boiteletre.DTO.DtoForAuth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import fr.tours.etu.boiteletre.Model.Role;
/**
 * @ClassName AuthResponseDTO
 * @Description  the DTO of the user for authentication it contains the token generated
 * the username and the role of the user
 * @Author Radia MERABTENE et Mamadou COULIBALY
 * @Date 09/12/2025 22:29
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
   private String token;
   private String username;
   private Role role;

}