package fr.tours.etu.boiteletre.DTO.DtoForUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDTO {
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String username;

    public ResponseUserDTO(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
    }
}
