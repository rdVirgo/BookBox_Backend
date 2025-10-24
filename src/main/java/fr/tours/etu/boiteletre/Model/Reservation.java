package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="reservation")
@Data
@NoArgsConstructor
public class Reservation {

    @EmbeddedId
    ReservationId reservationId;

    @Column(nullable = false)
    private int reservationNb;

    public Reservation(ReservationId reservationId, int reservationNb){
        this.reservationId = reservationId;
        this.reservationNb = reservationNb;
    }

}
