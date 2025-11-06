package fr.tours.etu.boiteletre.DTO.DtoForBox;

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

}
