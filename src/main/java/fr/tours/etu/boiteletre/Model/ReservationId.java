package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
/**
 *  A  special class to create the composed Id of the reservation class
 *
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ReservationId implements Serializable {

    /**
     * boxId : int the id of the reserved box
     */
    @Column(name = "box_id")
    private int boxId;
    /**
     * UserId  : int the id of the user doing the reservation
     */
    @Column(name = "user_id")
    private int userId;

}
