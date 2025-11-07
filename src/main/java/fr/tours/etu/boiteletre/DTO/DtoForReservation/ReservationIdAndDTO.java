package fr.tours.etu.boiteletre.DTO.DtoForReservation;

import fr.tours.etu.boiteletre.Model.ReservationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationIdAndDTO {
    private ReservationId reservationId;
    private ReservationDTO reservationDTO;
}
