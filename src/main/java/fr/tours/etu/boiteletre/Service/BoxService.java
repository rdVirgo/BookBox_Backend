package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.Model.Box;
import fr.tours.etu.boiteletre.Repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {

    private final BoxRepository boxRepository;

    @Autowired
    public BoxService(BoxRepository boxRepository){
        this.boxRepository = boxRepository;
    }


    public Box createBox(Box box){
        return boxRepository.save(box);
    }


    public void deleteBoxById(int id){
        boxRepository.deleteById(id);
    }

    public List<Box> getAllBox(){
        return boxRepository.findAll();
    }

    public Box getBoxById(int id){
        return boxRepository.findById(id).orElse(null);
    }

    public Box updateBox(int id, String name, int quantity, String description){
        Box box = boxRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Boite not found !"));

        box.setName(name);
        box.setQuantity(quantity);
        box.setDescription(description);

        return boxRepository.save(box);
    }

}
