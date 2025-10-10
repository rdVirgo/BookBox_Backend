package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.Model.Boite;
import fr.tours.etu.boiteletre.Model.Coordonnees;
import fr.tours.etu.boiteletre.Repository.CoordonneesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordonneesService {

    private final CoordonneesRepository coordonneesRepository;

    @Autowired
    public CoordonneesService(CoordonneesRepository coordonneesRepository){
        this.coordonneesRepository = coordonneesRepository;
    }

    public Coordonnees addCoordonnees(String latitude, String longitude){
        Coordonnees coordonnees = new Coordonnees(latitude, longitude);
        return coordonneesRepository.save(coordonnees);
    }

    public Coordonnees addCoordonnees(Coordonnees coordonnees){
        return coordonneesRepository.save(coordonnees);
    }

    public void deleteCoordonneesById(int id){
        coordonneesRepository.deleteById(id);
    }

    public List<Coordonnees> getAllCoordonnes(){
        return coordonneesRepository.findAll();
    }

    public Coordonnees updateCoordonnees(int id, String latitude, String longitude){
        Coordonnees boite = coordonneesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Boite not found !"));

        boite.setLatitude(latitude);
        boite.setLongitude(longitude);

        return coordonneesRepository.save(boite);
    }

}
