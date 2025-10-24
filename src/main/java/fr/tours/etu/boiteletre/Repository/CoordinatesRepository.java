package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer> {
}
