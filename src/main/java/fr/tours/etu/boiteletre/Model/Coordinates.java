package fr.tours.etu.boiteletre.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;
/**
 *  A coordinates model class
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
@Entity
@Table(name="coordinates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    /**
     * coordinatesId : an int unique for each coordinate
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int coordinatesId;
    /**
     * latitude : String
     */
    @Column(nullable = false)
    private String latitude;
    /**
     * longitude : string
     */
    @Column(nullable = false)
    private String longitude;

}
