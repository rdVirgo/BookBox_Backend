package fr.tours.etu.boiteletre.Model;
import jakarta.persistence.*;
import  lombok.Data;

@Entity
@Table(name="coordonnees")
@Data
public class Coordonnees {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int coordonneesId;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    public Coordonnees() {}
    public Coordonnees(String latitude, String longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

}
