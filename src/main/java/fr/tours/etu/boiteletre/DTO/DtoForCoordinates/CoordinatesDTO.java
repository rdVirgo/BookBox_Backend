package fr.tours.etu.boiteletre.DTO.DtoForCoordinates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
/**
 * A DTO class for the Coordinates entity for the transmission part
 *
 * @author Mamadou COULIBALY & Rdvirgo
 * @version 1.0
        */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesDTO {
    /**
     * coordinatesId the id of the object (unique).
     */
    private int coordinatesId;
    /**
     * Latitude : a string
     */
    private String latitude;
    /**
     * Longitude : a string
     */
    private String longitude;
}
