package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *  A repository Interface for the Coordinates
 *  contains essential functions for the CRUD
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}
