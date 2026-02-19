package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.DTO.DtoForBox.BoxDTO;
import fr.tours.etu.boiteletre.Service.BoxService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  A controller class for the Box entity.
 * It contains  the crud operations for the user side.
 *
 * @author Mamadou COULIBALY & Rdvirgo
 * @version 1.0
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/box")
public class BoxController {
    /**
     * the boxService object.
     */
    private final BoxService boxService;

    /**
     * Creates a new box.
     *
     * @param boxDTO a DTO object containing information about the box to be created.
     * @return A ResponseBoxDTO containing details of the created box.
     */
    @PostMapping
    public  BoxDTO createBox(@Valid @RequestBody BoxDTO boxDTO){
        return boxService.createBox(boxDTO);
    }

    /**
     * Retrieves all the existing boxes in the database.
     * @return a list of the boxes found in the database
     */
    @GetMapping
    public List<BoxDTO> getAllBox(){
        return boxService.getAllBox();
    }

    /**
     * Retrieves the box of the given parameter ID
     * @param id the id of the box
     * @return A ResponseBoxDTO containing the specific box with its details
     */
    @GetMapping("/{id}")
    public BoxDTO getBoxById(@PathVariable int id){
        return boxService.getBoxById(id);
    }

    /**
     * Update a specific box selected by its ID
     * @param id the id parameter of the box to update
     * @param boxDTO the new box containing the updated box information.
     * @return a ResponseBoxDTO containing the box updated with the new information
     */

    @PutMapping("/{id}")
    public BoxDTO updateBox(@PathVariable int id, @Valid @RequestBody BoxDTO boxDTO){
        return boxService.updateBox(id, boxDTO);
    }

    /**
     * Delete a box corresponding to the given ID
     * @param id the id parameter of the box to delete
     */
    @DeleteMapping("/{id}")
    public void deleteBoxById(@PathVariable int id){
            boxService.deleteBoxById(id);
    }

}
