package fr.tours.etu.boiteletre.DTO.DtoForAuth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ClassName AuthDTO
 * @Description TODO
 * @Author Mamadou COULIBALY & rdvirgo
 * @Date 09/12/2025 21:36
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {
    private String username;
    private String password;
}
