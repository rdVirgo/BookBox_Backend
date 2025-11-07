package fr.tours.etu.boiteletre.DTO.DtoForReservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    ReservationId reservationId;
    private int reservationNb;
}
