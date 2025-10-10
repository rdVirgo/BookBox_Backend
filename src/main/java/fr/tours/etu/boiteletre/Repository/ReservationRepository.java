package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
