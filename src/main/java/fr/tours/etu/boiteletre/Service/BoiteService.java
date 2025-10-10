package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.Model.Boite;
import fr.tours.etu.boiteletre.Repository.BoiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoiteService {

    private final BoiteRepository boiteRepository;

    @Autowired
    public BoiteService(BoiteRepository boiteRepository){
        this.boiteRepository = boiteRepository;
    }


    public Boite addBoite(Boite boite){
        return boiteRepository.save(boite);
    }

    public void deleteBoiteById(int id){
        boiteRepository.deleteById(id);
    }

    public List<Boite> getAllBoite(){
        return boiteRepository.findAll();
    }

    public Boite getBoiteById(int id){
        return boiteRepository.findById(id).orElse(null);
    }

    public Boite updateBoite(int id, String name, int quantity, String description){
        Boite boite = boiteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Boite not found !"));

        boite.setNom(name);
        boite.setQuantite(quantity);
        boite.setDescription(description);

        return boiteRepository.save(boite);
    }

}
