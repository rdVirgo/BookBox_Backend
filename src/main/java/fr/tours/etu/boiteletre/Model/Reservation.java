package fr.tours.etu.boiteletre.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import  lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @EmbeddedId
    ReservationId reservationId;

    @Column(nullable = false)
    private int reservationNb;

}
