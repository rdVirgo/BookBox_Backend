package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;


@Entity
@Table(name="boite")
public class Boite {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int boiteId;
    private String nom;
    private int quantite;
    private String description;
    @OneToOne
    @JoinColumn(name="coordonneesId")
    private Coordonnees coordonneesid;
    public Boite() {}
    public Boite( String nom, int quantite, String description) {

        this.nom = nom;
        this.quantite = quantite;
        this.description = description;
    }

    public int getBoiteId() {
        return boiteId;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
