package fr.tours.etu.boiteletre.DTO;
import lombok.Data;

import java.util.Objects;

@Data
public class UserDTO {
    private int userId;
    private String name;
    private String surname;
    private String email;
    private String username;

    // constructor
    public UserDTO(int userId, String name, String surname, String email, String username) {
        this.userId = userId;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UserDTO user = (UserDTO) obj;
        return this.userId == user.userId &&
                Objects.equals(this.username, user.username) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.surname, user.surname) &&
                Objects.equals(this.name, user.name);
    }

}
