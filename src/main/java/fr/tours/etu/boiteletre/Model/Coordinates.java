package fr.tours.etu.boiteletre.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="coordinates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int coordinatesId;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;


    public Coordinates(String latitude, String longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

}
