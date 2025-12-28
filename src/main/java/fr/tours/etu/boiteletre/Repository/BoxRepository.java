package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *  A repository Interface for the Box
 *  contains essential functions for the CRUD
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {
}
