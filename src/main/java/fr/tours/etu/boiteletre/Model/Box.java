package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 *  A  model class for the box
 *
 * @author Mamadou COULIBALY & Rdvirgo
 
 * @version 1.0
 */
@Entity
@Table(name="box")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Box {
    /**
     * boxid : int a unique value for each box
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    private int boxId;
    /**
     * name : string the name of the box
     */
    @Column(nullable = false)
    @NotBlank
    private String name;
    /**
     * quantity : int number of books in the box
     */
    @Column(nullable = false)
    @NotNull
    @Min(value = 0)
    private int quantity;

    /**
     * description : String describing the box.
     */
    @Column
    private String description;
    /**
     * the coordinates of the box
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="coordinates_id", referencedColumnName = "coordinatesId", unique = true)
    @NotNull
    private Coordinates coordinates;


}
