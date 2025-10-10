package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Coordonnees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordonneesRepository  extends JpaRepository<Coordonnees, Integer> {
}
