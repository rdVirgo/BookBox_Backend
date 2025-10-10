package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.Model.Coordonnees;
import fr.tours.etu.boiteletre.Service.CoordonneesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordonnes")
public class CoordonneesController {

    private final CoordonneesService coordonneesService;

    public CoordonneesController(CoordonneesService coordonneesService){
        this.coordonneesService = coordonneesService;
    }

    @PostMapping
    public Coordonnees addCoordonnes(@RequestParam String latitude, @RequestParam String longitude){
        return coordonneesService.addCoordonnees(latitude, longitude);
    }

    @PostMapping
    public Coordonnees addCoordonnes(@RequestParam Coordonnees coordonnees){
        return coordonneesService.addCoordonnees(coordonnees);
    }

    @GetMapping
    public List<Coordonnees> getAllCoordonnees(){
        return coordonneesService.getAllCoordonnes();
    }

    @PutMapping
    public Coordonnees updateCoordonnees(@PathVariable int id, @RequestParam String latitude, @RequestParam String longitude){
        return coordonneesService.updateCoordonnees(id, latitude, longitude);
    }

    @DeleteMapping("/{id}")
    public void deleteCoordonneesById(@RequestParam int id){
        coordonneesService.deleteCoordonneesById(id);
    }

}
