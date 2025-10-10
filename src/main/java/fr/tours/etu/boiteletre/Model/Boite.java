package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import  lombok.Data;
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
    private Coordonnees coordonneesid;


    public Boite( String nom, int quantite, String description) {

        this.nom = nom;
        this.quantite = quantite;
        this.description = description;
    }


}
