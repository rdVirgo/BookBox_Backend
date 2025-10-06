package fr.tours.etu.boiteletre.Model;
import jakarta.persistence.*;

@Entity
@Table(name="coordonnees")
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

    public int getCoordonneesId() {
        return coordonneesId;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
