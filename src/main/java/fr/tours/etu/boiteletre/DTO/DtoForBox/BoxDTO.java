package fr.tours.etu.boiteletre.DTO.DtoForBox;

import fr.tours.etu.boiteletre.Model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxDTO {

    private int boxId;
    private String name;
    private int quantity;
    private String description;
    private Coordinates coordinates;

}
