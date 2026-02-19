package fr.tours.etu.boiteletre.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;
/**
 *  A reservation model class
 * @author Mamadou COULIBALY & rdvirgo
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
    @NotNull
    @EmbeddedId
    ReservationId reservationId;

    @ManyToOne
    @MapsId("boxId")
    @JoinColumn(name = "box_id")
    private Box box;


    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * reservationNb : int number of the reservation
     */
    @Column(nullable = false)
    @NotNull
    @Min(value = 0)
    private int reservationNb;

}
