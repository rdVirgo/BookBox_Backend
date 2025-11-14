package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.MappStruct.CoordinatesMapper;
import fr.tours.etu.boiteletre.Model.Coordinates;
import fr.tours.etu.boiteletre.Repository.CoordinatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 *  A  service class for the coordinates entity
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class CoordinatesService {
    /**
     * coordinatesRepository
     */
    private final CoordinatesRepository coordinatesRepository;
    /**
     * a coordinatesMapper
     */
    private final CoordinatesMapper coordinatesMapper;

    /**
     * create a new coordinates Object
     * @param coordinatesDTO
     * @return CoordinatesDTO
     */
    public CoordinatesDTO createCoordinates(CoordinatesDTO coordinatesDTO){

        Coordinates coordinates = coordinatesMapper.dtoToCoordinates(coordinatesDTO);
        Coordinates saveCoordinates = coordinatesRepository.save(coordinates);

        return coordinatesMapper.coordinatesToDto(saveCoordinates);
    }

    /**
     * read the list of the coordinates from the database
     * @return list of coordinatesDTO
     */
    public List<CoordinatesDTO> getAllCoordinates(){

        List<Coordinates> coordinatesList = coordinatesRepository.findAll();
        List<CoordinatesDTO> coordinatesDTOS = new ArrayList<>();

        if (!coordinatesList.isEmpty()){
            for (Coordinates c : coordinatesList) {
                coordinatesDTOS.add(coordinatesMapper.coordinatesToDto(c));
            }
        }

        return coordinatesDTOS;
    }

    /**
     * read the coordinatesDTO object of the given id
     * @param id : int the id of the coordinate object to read
     * @return CoordinatesDTO
     */
    public CoordinatesDTO getCoordinatesById(int id){

        Coordinates coordinates = coordinatesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Coordinates with id : " + id + " doesn't exist"));

        return coordinatesMapper.coordinatesToDto(coordinates);
    }

    /**
     * update the coordinates object of the given id
     * @param id int the id of the coordinate to update
     * @param coordinatesDTO the coordinatesDTO object containing the new information
     * @return CoordinatesDTO
     */
    public CoordinatesDTO updateCoordinates(int id, CoordinatesDTO coordinatesDTO){
        Coordinates coordinates = coordinatesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Box with the id : " + id + " not found. So cannot be updated!"));

        coordinates.setLatitude(coordinatesDTO.getLatitude());
        coordinates.setLongitude(coordinatesDTO.getLongitude());

        Coordinates saveCoordinates = coordinatesRepository.save(coordinates);


        return coordinatesMapper.coordinatesToDto(saveCoordinates);
    }

    /**
     * delete the coordinatesDTO for the given id
     * @param id int the id of the coordinates to delete
     */
    public void deleteCoordinatesById(int id) {
        if (coordinatesRepository.existsById(id)){
            coordinatesRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Coordinates cannot be deleted." + " id : " + id + " not found!");
        }

    }

}
