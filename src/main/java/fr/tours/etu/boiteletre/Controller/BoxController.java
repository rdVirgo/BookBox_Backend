package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.Model.Box;
import fr.tours.etu.boiteletre.Service.BoxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/box")
public class BoxController {

    private final BoxService boxService;

    public BoxController(BoxService boxService){
        this.boxService = boxService;
    }


    @PostMapping
    public Box createBox(@RequestBody Box box){
        return boxService.createBox(box);
    }

    @GetMapping
    public List<Box> getAllBox(){
        return boxService.getAllBox();
    }

    @GetMapping("/{id}")
    public Box getAllBox(@PathVariable int id){
        return boxService.getBoxById(id);
    }

    @PutMapping
    public Box updateBox(@PathVariable int id, @RequestParam String name, @RequestParam int quantity, @RequestParam String description){
        return boxService.updateBox(id, name, quantity, description);
    }

    @DeleteMapping("/{id}")
    public void deleteBoxById(@PathVariable int id){
        boxService.deleteBoxById(id);
    }

}
