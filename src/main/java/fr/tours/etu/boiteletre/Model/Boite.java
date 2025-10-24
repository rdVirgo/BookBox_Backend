package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name="boite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boite {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boiteId;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int quantite;

    @Column
    private String description;
    
    @OneToOne
    @JoinColumn(name="coordonneesId")
    private Coordonnees coordonnees;


    public Boite( String nom, int quantite, String description, int coordonnees_id) {
        this.nom = nom;
        this.quantite = quantite;
        this.description = description;

    }


}
