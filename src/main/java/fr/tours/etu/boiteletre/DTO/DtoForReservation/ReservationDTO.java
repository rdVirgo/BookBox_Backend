package fr.tours.etu.boiteletre.DTO.DtoForReservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  A DTO for the reservation entity.
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
        */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    /**
     * a reservationId object to represent the boxId and the UserId
     */
    ReservationId reservationId;
    /**
     * reservationNb : int for the number of the reservations
     */
    private int reservationNb;
}
