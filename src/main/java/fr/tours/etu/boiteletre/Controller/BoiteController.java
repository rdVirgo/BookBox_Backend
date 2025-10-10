package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.Model.Boite;
import fr.tours.etu.boiteletre.Service.BoiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boite")
public class BoiteController {

    private final BoiteService boiteService;

    public BoiteController(BoiteService boiteService){
        this.boiteService = boiteService;
    }

    @PostMapping
    public Boite addBoite(@RequestParam String name, @RequestParam int quantity, @RequestParam String description){
        return boiteService.addBoite(name, quantity, description);
    }

    @PostMapping
    public Boite addBoite(@RequestParam Boite boite){
        return boiteService.addBoite(boite);
    }

    @GetMapping
    public List<Boite> getAllBoite(){
        return boiteService.getAllBoite();
    }

    @GetMapping("/{id}")
    public Boite getAllBoite(@PathVariable int id){
        return boiteService.getBoiteById(id);
    }

    @PutMapping
    public Boite updateBoite(@PathVariable int id, @RequestParam String name, @RequestParam int quantity, @RequestParam String description){
        return boiteService.updateBoite(id, name, quantity, description);
    }

    @DeleteMapping("/{id}")
    public void deleteBoiteById(@PathVariable int id){
        boiteService.deleteBoiteById(id);
    }

}
