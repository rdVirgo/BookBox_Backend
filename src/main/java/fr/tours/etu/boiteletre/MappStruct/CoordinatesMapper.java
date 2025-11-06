package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.Model.Coordinates;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordinatesMapper {
    CoordinatesDTO coordinatesToDto(Coordinates coordinates);
    Coordinates dtoToCoordinates(CoordinatesDTO coordinatesDTO);
}
