package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="utilisateur")
@Data
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int utilisateurId;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;

    public Utilisateur() {}
    public Utilisateur(String nom, String prenom, String email, String password, String username) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.username = username;
    }

}
