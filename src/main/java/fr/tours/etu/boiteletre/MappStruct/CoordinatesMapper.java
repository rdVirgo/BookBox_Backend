package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.Model.Coordinates;
import org.mapstruct.Mapper;
/**
 *  A mapper interface for the coordinates objects
 * Turn a normal coordinates object into a coordinatesDTO
 * Turn a DTO coordinates object into a normal object
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CoordinatesMapper {
    /**
     * To convert a coordinates into a coordinatesDTO
     * @param coordinates
     * @return a CoordinatesDTO
     */
    CoordinatesDTO coordinatesToDto(Coordinates coordinates);

    /**
     * To convert a coordinatesDTO to a coordinates
     * @param coordinatesDTO
     * @return a coordinates
     */
    Coordinates dtoToCoordinates(CoordinatesDTO coordinatesDTO);
}
