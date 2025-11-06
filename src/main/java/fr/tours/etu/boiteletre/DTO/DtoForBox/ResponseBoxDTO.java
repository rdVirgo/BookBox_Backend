package fr.tours.etu.boiteletre.DTO.DtoForBox;

import fr.tours.etu.boiteletre.Model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoxDTO {
    private int boxId;
    private String name;
    private String description;
    private Coordinates coordinates;

    public ResponseBoxDTO(BoxDTO boxDTO) {
        this.boxId = boxDTO.getBoxId();
        this.name = boxDTO.getName();
        this.description = boxDTO.getDescription();
        this.coordinates = boxDTO.getCoordinates();
    }
}
