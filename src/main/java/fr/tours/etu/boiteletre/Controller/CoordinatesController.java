package fr.tours.etu.boiteletre.Controller;
// import
import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.Service.CoordinatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  A controller class for the Coordinates entity.
 * It contains  the crud operations for the user side.
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
@RestController
@RequestMapping("/api/coordinates")
@RequiredArgsConstructor
public class CoordinatesController {
    /**
     *  the CoordinatesService object
     */
    private final CoordinatesService coordinatesService;

    /**
     * Creates a new coordinate.
     *
     * @param coordinatesDTO a DTO object containing information about the coordinate to be created.
     * @return A CoordinatesDTO containing details of the created coordinate.
     */
    @PostMapping
    public CoordinatesDTO createCoordinates(@RequestBody CoordinatesDTO coordinatesDTO){
        return coordinatesService.createCoordinates(coordinatesDTO);
    }

    /**
     * Retrieves all the existing coordinates in the database.
     * @return a list of the coordinates  found in the database
     */
    @GetMapping
    public List<CoordinatesDTO> getAllCoordinates(){
        return coordinatesService.getAllCoordinates();
    }

    /**
     * Retrieves the coordinates of the given parameter ID
     * @param id the id of the coordinate
     * @return A CoordinatesDTO containing the specific coordinate with its details
     */
    @GetMapping("/{id}")
    public CoordinatesDTO getCoordinatesById(@PathVariable int id){
            return coordinatesService.getCoordinatesById(id);
    }

    /**
     * Update a specific coordinate selected by its ID
     * @param id the id parameter of the coordinate to update
     * @param coordinatesDTO the new coordinate containing the updated box information.
     * @return a CoordinatesDTO containing the coordinate updated with the new information
     */
    @PutMapping("/{id}")
    public CoordinatesDTO updateCoordinates(@PathVariable int id, @RequestBody CoordinatesDTO coordinatesDTO){

            return coordinatesService.updateCoordinates(id, coordinatesDTO);
    }

    /**
     * Delete a coordinate corresponding to the given ID
     * @param id the id parameter of the coordinate to delete
     */
    @DeleteMapping("/{id}")
    public void deleteCoordinateById(@PathVariable int id) {
            coordinatesService.deleteCoordinatesById(id);
    }

}
