package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;
/**
 *  A reservation model class
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */

@Entity
@Table(name="reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    /**
     * reservationId : containing both the userId and the BoxId (special class)
     */
    @EmbeddedId
    ReservationId reservationId;
    /**
     * reservationNb : int number of the reservation
     */
    @Column(nullable = false)
    private int reservationNb;

}
