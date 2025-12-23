package fr.tours.etu.boiteletre.Service;

import fr.tours.etu.boiteletre.DTO.DtoForBox.BoxDTO;
import fr.tours.etu.boiteletre.DTO.DtoForCoordinates.CoordinatesDTO;
import fr.tours.etu.boiteletre.Exception.ApiException;
import fr.tours.etu.boiteletre.MappStruct.BoxMapper;
import fr.tours.etu.boiteletre.MappStruct.CoordinatesMapper;
import fr.tours.etu.boiteletre.Model.Box;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Repository.BoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  A service Class for the Box entity
 *
 * @author Coulibaly Mamadou & Radia MERABTENE
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class BoxService {
    /**
     * a boxRepository object
     */
    private final BoxRepository boxRepository;

    /**
     * Reservation service to manage action related to reservation.
     */
    private final ReservationService reservationService;

    private final CoordinatesService coordinatesService;

    private final CoordinatesMapper coordinatesMapper;

    /**
     * a Boxmapper Object
     */
    private final BoxMapper boxMapper;



    /**
     * creating a new BoxDTO
     * @param boxDTO
     * @return the created boxDTO
     */
    public  BoxDTO createBox(BoxDTO boxDTO){

        Box box = boxMapper.dtoToBox(boxDTO);
        Box saveBox = boxRepository.save(box);

        BoxDTO dtoBox = boxMapper.boxToDto(saveBox);

        return new  BoxDTO(dtoBox);
    }

    /**
     * read all the list of the Boxes from the database
     * @return a BoxDTO list
     */
    public List<BoxDTO> getAllBox(){
        List<Box> boxList = boxRepository.findAll();
        List<BoxDTO> responseBoxDTOList = new ArrayList<>();

        if (!boxList.isEmpty()){
            for (Box b : boxList) {
                responseBoxDTOList.add(new BoxDTO(boxMapper.boxToDto(b)));
            }
        }
        return responseBoxDTOList;
    }

    /**
     * get a specific box that machs the id in the parameter
     * @param id : int the id of the box to read
     * @return a BoxDTO
     */
    public  BoxDTO getBoxById(int id){
        Box box = boxRepository.findById(id).orElseThrow(()-> new ApiException("The box with the id : " + id + " doesn't exist!",HttpStatus.NOT_FOUND));

        return new  BoxDTO(boxMapper.boxToDto(box));
    }

    /**
     * update a specific box according to the id in the parameter
     * @param id : int the id of the box to update
     * @param boxDTO : the box containing the new values
     * @return BoxDTO
     */
    public BoxDTO updateBox(int id, BoxDTO boxDTO){
        Box box = boxRepository.findById(id).orElseThrow(()-> new ApiException("The box with the id : " + id + " doesn't exist!",HttpStatus.NOT_FOUND));

        CoordinatesDTO coordinatesDTO = new CoordinatesDTO(box.getCoordinates().getCoordinatesId(),
                boxDTO.getCoordinates().getLatitude(), boxDTO.getCoordinates().getLongitude());

        CoordinatesDTO updateCoordinates = coordinatesService.updateCoordinates(box.getCoordinates().getCoordinatesId(),coordinatesDTO);

        System.out.println("Coordinates : " + updateCoordinates.getCoordinatesId() +
                " - " + updateCoordinates.getLatitude() + " - " + updateCoordinates.getLongitude());

        box.setName(boxDTO.getName());
        box.setQuantity(boxDTO.getQuantity());
        box.setDescription(boxDTO.getDescription());



        box.setCoordinates(this.coordinatesMapper.dtoToCoordinates(updateCoordinates));

        return new BoxDTO(boxMapper.boxToDto(boxRepository.save(box)));
    }

    /**
     * delete a box of the given id in the parameter
     * @param id int : the id of the box to delete
     */
    public void deleteBoxById(int id){

        Box box = this.boxRepository.findById(id).orElseThrow(
                ()-> new ApiException("The box with the id : " + id + " doesn't exist!", HttpStatus.NOT_FOUND)
        );

        List<Reservation> reservationList = this.reservationService.getAllReservations();

        for (Reservation reservation : reservationList){
            if (reservation.getBox().getBoxId() == box.getBoxId()){
                ReservationId reservationId = new ReservationId(reservation.getBox().getBoxId(), reservation.getUser().getUserId());
                this.reservationService.deleteReservation(reservationId);
            }
        }

        boxRepository.deleteById(id);

    }

}
