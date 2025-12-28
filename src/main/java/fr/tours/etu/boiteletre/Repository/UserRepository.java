package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *  A repository Interface for the User
 *  contains essential functions for the CRUD
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
