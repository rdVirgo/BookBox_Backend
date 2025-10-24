package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
