package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.Model.Coordinates;
import fr.tours.etu.boiteletre.Repository.CoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatesService {

    private final CoordinatesRepository coordinatesRepository;

    @Autowired
    public CoordinatesService(CoordinatesRepository coordinatesRepository){
        this.coordinatesRepository = coordinatesRepository;
    }

    public Coordinates createCoordinates(Coordinates coordinates){
        return coordinatesRepository.save(coordinates);
    }

    public void deleteCoordinatesById(int id){
        coordinatesRepository.deleteById(id);
    }

    public List<Coordinates> getAllCoordinates(){
        return coordinatesRepository.findAll();
    }

    public Coordinates getCoordinatesById(int id){
        return coordinatesRepository.findById(id).orElse(null);
    }

    public Coordinates updateCoordinates(int id, String latitude, String longitude){
        Coordinates box = coordinatesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Box not found !"));

        box.setLatitude(latitude);
        box.setLongitude(longitude);


        return coordinatesRepository.save(box);
    }

}
