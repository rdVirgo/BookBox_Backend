package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  A repository Interface for the User
 *  contains essential functions for the CRUD
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
