package fr.tours.etu.boiteletre.DTO;
import fr.tours.etu.boiteletre.Model.ReservationId;
import lombok.Data;

@Data
public class ReservationDTO {
    ReservationId reservationId;
    private int reservationNb;

    // constructor
    public ReservationDTO() {}
    public ReservationDTO(ReservationId reservationId,int reservationNb) {
        this.reservationNb = reservationNb;
        this.reservationId = reservationId;
    }
}
