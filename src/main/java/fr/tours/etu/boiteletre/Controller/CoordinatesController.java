package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.Model.Coordinates;
import fr.tours.etu.boiteletre.Service.CoordinatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordinates")
@RequiredArgsConstructor
public class CoordinatesController {

    private final CoordinatesService coordinatesService;

    @PostMapping
    public CoordinatesDTO createCoordinates(@RequestBody CoordinatesDTO coordinatesDTO){
        return coordinatesService.createCoordinates(coordinatesDTO);
    }

    @GetMapping
    public List<CoordinatesDTO> getAllCoordinates(){
        return coordinatesService.getAllCoordinates();
    }

    @GetMapping("/{id}")
    public CoordinatesDTO getCoordinatesById(@PathVariable int id){
        try{
            return coordinatesService.getCoordinatesById(id);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @PutMapping("/{id}")
    public CoordinatesDTO updateCoordinates(@PathVariable int id, @RequestBody CoordinatesDTO coordinatesDTO){
        try{
            return coordinatesService.updateCoordinates(id, coordinatesDTO);
        }catch (IllegalArgumentException ex){
            System.err.println("Error : " + ex.getMessage());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCoordinateById(@PathVariable int id){
        try{
            coordinatesService.deleteCoordinatesById(id);
        }catch (IllegalAccessException ex){
            System.err.println("Error : " + ex.getMessage());
        }

    }

}
