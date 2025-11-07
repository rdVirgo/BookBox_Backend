package fr.tours.etu.boiteletre.Controller;

import fr.tours.etu.boiteletre.DTO.DtoForBox.BoxDTO;
import fr.tours.etu.boiteletre.DTO.DtoForBox.ResponseBoxDTO;
import fr.tours.etu.boiteletre.Model.Box;
import fr.tours.etu.boiteletre.Service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/box")
public class BoxController {

    private final BoxService boxService;

    @PostMapping
    public ResponseBoxDTO createBox(@RequestBody BoxDTO boxDTO){
        return boxService.createBox(boxDTO);
    }

    @GetMapping
    public List<ResponseBoxDTO> getAllBox(){
        return boxService.getAllBox();
    }

    @GetMapping("/{id}")
    public ResponseBoxDTO getBoxById(@PathVariable int id){
        return boxService.getBoxById(id);
    }

    @PutMapping("/{id}")
    public ResponseBoxDTO updateBox(@PathVariable int id, @RequestBody BoxDTO boxDTO){
        return boxService.updateBox(id, boxDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBoxById(@PathVariable int id){
            boxService.deleteBoxById(id);
    }

}
