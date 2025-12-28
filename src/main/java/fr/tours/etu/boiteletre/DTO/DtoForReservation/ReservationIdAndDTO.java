package fr.tours.etu.boiteletre.DTO.DtoForReservation;

import fr.tours.etu.boiteletre.Model.ReservationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  A DTO for the ReservationId class.
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
        */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationIdAndDTO {
    /**
     *
     */
    private ReservationId reservationId;
    private ReservationDTO reservationDTO;
}
