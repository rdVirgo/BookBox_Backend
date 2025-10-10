package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
