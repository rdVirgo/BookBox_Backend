package fr.tours.etu.boiteletre.DTO.DtoForCoordinates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesDTO {
    private int coordinatesId;
    private String latitude;
    private String longitude;
}
