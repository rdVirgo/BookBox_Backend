package fr.tours.etu.boiteletre.MappStruct;

import fr.tours.etu.boiteletre.DTO.DtoForBox.BoxDTO;
import fr.tours.etu.boiteletre.Model.Box;
import org.mapstruct.Mapper;
/**
 *  A mapper interface for the Box entity
 *  to transform a dto object to a normal entity
 *  and to transform a normal object to a dto
 * @author Mamadou COULIBALY & Rdvirgo
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface BoxMapper {
    /**
     * To transform a normal box to a BoxDTO
     * @param box : a Box object
     * @return a BoxDTO object
     */
    BoxDTO boxToDto(Box box);

    /**
     * to transform a DTOBox to a normal box
     * @param boxDTO : a dto box object
     * @return a normal box
     */
    Box dtoToBox(BoxDTO boxDTO);

}
