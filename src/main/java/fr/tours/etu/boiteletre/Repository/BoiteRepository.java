package fr.tours.etu.boiteletre.Repository;

import fr.tours.etu.boiteletre.Model.Boite;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoiteRepository  extends JpaRepository<Boite, Integer> {
}
