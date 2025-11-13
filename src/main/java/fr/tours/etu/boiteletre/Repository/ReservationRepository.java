package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  A repository Interface for the reservation
 *  contains essential functions for the CRUD
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
}
