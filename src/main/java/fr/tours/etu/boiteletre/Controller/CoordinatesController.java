package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.Model.Coordinates;
import fr.tours.etu.boiteletre.Service.CoordinatesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordinates")
public class CoordinatesController {

    private final CoordinatesService coordinatesService;

    public CoordinatesController(CoordinatesService coordinatesService){
        this.coordinatesService = coordinatesService;
    }


    @PostMapping
    public Coordinates createCoordinates(@RequestBody Coordinates coordinates){
        return coordinatesService.createCoordinates(coordinates);
    }

    @GetMapping
    public List<Coordinates> getAllCoordinates(){
        return coordinatesService.getAllCoordinates();
    }

    @PutMapping
    public Coordinates updateCoordinates(@PathVariable int id, @RequestParam String latitude, @RequestParam String longitude){
        return coordinatesService.updateCoordinates(id, latitude, longitude);
    }

    @DeleteMapping("/{id}")
    public void deleteCoordinateById(@PathVariable int id){
        coordinatesService.deleteCoordinatesById(id);
    }

}
