package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {
}
