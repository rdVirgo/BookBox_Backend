package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForBox.BoxDTO;
import fr.tours.etu.boiteletre.Model.Box;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoxMapper {

    BoxDTO boxToDto(Box box);
    Box dtoToBox(BoxDTO boxDTO);

}
