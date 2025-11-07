package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.DTO.DtoForBox.BoxDTO;
import fr.tours.etu.boiteletre.DTO.DtoForBox.ResponseBoxDTO;
import fr.tours.etu.boiteletre.MappStruct.BoxMapper;
import fr.tours.etu.boiteletre.Model.Box;
import fr.tours.etu.boiteletre.Repository.BoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoxService {

    private final BoxRepository boxRepository;
    private final BoxMapper boxMapper;

    public ResponseBoxDTO createBox(BoxDTO boxDTO){

        Box box = boxMapper.dtoToBox(boxDTO);
        Box saveBox = boxRepository.save(box);

        BoxDTO dtoBox = boxMapper.boxToDto(saveBox);

        return new ResponseBoxDTO(dtoBox);
    }


    public List<ResponseBoxDTO> getAllBox(){
        List<Box> boxList = boxRepository.findAll();
        List<ResponseBoxDTO> responseBoxDTOList = new ArrayList<>();

        if (!boxList.isEmpty()){
            for (Box b : boxList) {
                responseBoxDTOList.add(new ResponseBoxDTO(boxMapper.boxToDto(b)));
            }
        }
        return responseBoxDTOList;
    }

    public ResponseBoxDTO getBoxById(int id){
        Box box = boxRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("The box with the id : " + id + " doesn't exist!"));

        return new ResponseBoxDTO(boxMapper.boxToDto(box));
    }

    public ResponseBoxDTO updateBox(int id, BoxDTO boxDTO){
        Box box = boxRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("The box with the id : " + id + " doesn't exist!"));

        box.setName(boxDTO.getName());
        box.setQuantity(boxDTO.getQuantity());
        box.setDescription(boxDTO.getDescription());

        return new ResponseBoxDTO(boxMapper.boxToDto(boxRepository.save(box)));
    }

    public void deleteBoxById(int id){

        if (boxRepository.existsById(id)){
            boxRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("The box with the id : " + id + " doesn't exist!");
        }

    }

}
