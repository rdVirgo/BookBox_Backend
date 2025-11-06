package fr.tours.etu.boiteletre.DTO.DtoForBox;

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

    public ResponseBoxDTO(BoxDTO boxDTO) {
        this.boxId = boxDTO.getBoxId();
        this.name = boxDTO.getName();
        this.description = boxDTO.getDescription();
    }
}
