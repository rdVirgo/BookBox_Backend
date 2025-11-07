package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.MappStruct.CoordinatesMapper;
import fr.tours.etu.boiteletre.Model.Coordinates;
import fr.tours.etu.boiteletre.Repository.CoordinatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoordinatesService {

    private final CoordinatesRepository coordinatesRepository;
    private final CoordinatesMapper coordinatesMapper;

    public CoordinatesDTO createCoordinates(CoordinatesDTO coordinatesDTO){

        Coordinates coordinates = coordinatesMapper.dtoToCoordinates(coordinatesDTO);
        Coordinates saveCoordinates = coordinatesRepository.save(coordinates);

        return coordinatesMapper.coordinatesToDto(saveCoordinates);
    }

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

    public CoordinatesDTO getCoordinatesById(int id){

        Coordinates coordinates = coordinatesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Coordinates with id : " + id + " doesn't exist"));

        return coordinatesMapper.coordinatesToDto(coordinates);
    }

    public CoordinatesDTO updateCoordinates(int id, CoordinatesDTO coordinatesDTO){
        Coordinates coordinates = coordinatesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Box with the id : " + id + " not found. So cannot be updated!"));

        coordinates.setLatitude(coordinatesDTO.getLatitude());
        coordinates.setLongitude(coordinatesDTO.getLongitude());

        Coordinates saveCoordinates = coordinatesRepository.save(coordinates);


        return coordinatesMapper.coordinatesToDto(saveCoordinates);
    }

    public void deleteCoordinatesById(int id) {
        if (coordinatesRepository.existsById(id)){
            coordinatesRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Coordinates cannot be deleted." + " id : " + id + " not found!");
        }

    }

}
