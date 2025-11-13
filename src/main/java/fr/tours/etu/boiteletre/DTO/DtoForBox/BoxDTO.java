package fr.tours.etu.boiteletre.DTO.DtoForBox;

import fr.tours.etu.boiteletre.Model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *  A DTO class for the box entity
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxDTO {
    /**
     * id : an int for a single Box
     */
    private int boxId;
    /**
     *  name : A string that represents the name of the box
     */
    private String name;
    /**
     * quantity : int (number) of the books that it contains
     */
    private int quantity;
    /**
     *  description : a string to describe the box
     */
    private String description;
    /**
     * Coordinates : coordinates of the box.
     */
    private Coordinates coordinates;

    /**
     * a constructor taking a boxdto as a parameter
     * @param box
     */
   public  BoxDTO(BoxDTO box) {
       this.boxId = box.boxId;
       this.name = box.name;
       this.quantity = box.quantity;
       this.description = box.description;
       this.coordinates = box.coordinates;
   };


}
