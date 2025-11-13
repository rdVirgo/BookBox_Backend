package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.*;

/**
 *  A  model class for the box
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
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
    private int boxId;
    /**
     * name : string the name of the box
     */
    @Column(nullable = false)
    private String name;
    /**
     * quantity : int number of books in the box
     */
    @Column(nullable = false)
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
    @JoinColumn(name="coordinatesId")
    private Coordinates coordinates;


}
