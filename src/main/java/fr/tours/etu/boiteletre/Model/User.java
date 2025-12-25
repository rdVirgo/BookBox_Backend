package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  A  user model class
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * userID : int unique for each user
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private int userId;
    /**
     * name : string the user's name
     */
    @Column(nullable = false)
    @NotBlank
    private String name;
    /**
     * surname : String the user's Surname
     */
    @Column(nullable = false)
    @NotBlank
    private String surname;
    /**
     * email : string the user's email
     */
    @Column(nullable = false)
    @NotBlank
    private String email;
    /**
     * password : string the user's password
     */
    @Column(nullable = false)
    @NotBlank
    private String password;
    /**
     * username : String the name of the user's account
     */
    @Column(nullable = false)
    @NotBlank
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
