package fr.tours.etu.boiteletre.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;
/**
 *  A coordinates model class
 *
 * @author Mamadou COULIBALY & Radia MERABTENE
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
    @NotNull
    private int coordinatesId;
    /**
     * latitude : String
     */
    @Column(nullable = false)
    @Min(value = -90)
    @Max(value = 90)
    @NotNull
    private String latitude;
    /**
     * longitude : string
     */
    @Column(nullable = false)
    @Min(value = -180)
    @Max(value = 180)
    @NotNull
    private String longitude;

}
